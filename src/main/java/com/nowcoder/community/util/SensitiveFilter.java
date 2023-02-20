package com.nowcoder.community.util;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class SensitiveFilter {

    private static final Logger logger = LoggerFactory.getLogger(SensitiveFilter.class);

    private static final String REPLACEMENT = "***";

    //root node
    private TrieNode rootNode = new TrieNode();

    @PostConstruct
    public void init() {
        try(

                InputStream is = this.getClass().getClassLoader().getResourceAsStream("sensitive-words.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        ) {
            String keyword;
            while ((keyword = reader.readLine()) != null) {
                // added to the prefix tree
                this.addKeyword(keyword);
            }

        } catch (IOException e) {
            System.out.println("???");
            logger.error("Failed to load sensitive word file: " + e.getMessage());
        }

    }

    // add sensitive word to trie
    private void addKeyword(String keyword) {
        TrieNode tempNode = rootNode;
        for(int i = 0; i < keyword.length(); i++ ) {
            char c = keyword.charAt(i);
            TrieNode subNode = tempNode.getSubNode(c);

            if (subNode == null) {
                // Initialize child nodes
                subNode = new TrieNode();
                tempNode.addSubNode(c, subNode);
            }

            // Point to the child node and enter the next cycle
            tempNode = subNode;

            // Set end flag
            if (i == keyword.length() - 1) {
                tempNode.setKeywordEnd(true);
            }
        }
    }

    /**
     * filter sensitive text
     * @param text : original  word
     * @return result after filter
     */
    public String filter(String text) {
        if (StringUtils.isBlank(text)) {
            return null;
        }

        // pointer 1
        TrieNode tempNode = rootNode;
        // pointer 2
        int begin = 0;
        // pointer 3
        int position = 0;
        // result
        StringBuilder sb = new StringBuilder();

        while (begin < text.length()) {
            if (position < text.length()) {
                char c = text.charAt(position);

                // skip symbol
                if (isSymbol(c)) {
                    // If pointer 1 is at the root node, count this symbol into the result and let pointer 2 go down one step
                    if (tempNode == rootNode) {
                        sb.append(c);
                        begin++;
                    }
                    // Regardless of whether the symbol is at the beginning or in the middle, pointer 3 is one step down
                    position++;
                    continue;
                }

                // check subordinate nodes
                tempNode = tempNode.getSubNode(c);
                if (tempNode == null) {
                    // Strings starting with begin are not sensitive words
                    sb.append(text.charAt(begin));
                    // go to next position
                    position = ++begin;
                    // redirect to the root node
                    tempNode = rootNode;
                } else if (tempNode.isKeywordEnd()) {
                    // If sensitive words are found, replace the begin~position string
                    sb.append(REPLACEMENT);
                    // go to next position
                    begin = ++position;

                } else {
                    // check next character
                    position++;
                }
            } else {
                //Position traverses out of bounds and still does not match sensitive words
                // Count the last batch of characters into the result
                sb.append(text.substring(begin));
                position = ++begin;
                // redirect to the root node
                tempNode = rootNode;
            }
        }
        return sb.toString();
    }

    // Determine whether it is a symbol
    private boolean isSymbol(Character c) {
        // 0x2E80~0x9FFF is an East Asian script range
        return !CharUtils.isAsciiAlphanumeric(c) && (c < 0x2E80 || c > 0x9FFF);
    }


    // Trie
    private class TrieNode {

        //end of word
        private boolean isKeywordEnd = false;

        // child
        private Map<Character, TrieNode> subNodes = new HashMap<>();

        public boolean isKeywordEnd() {
            return isKeywordEnd;
        }

        public void setKeywordEnd(boolean keyWordEnd) {
            isKeywordEnd = keyWordEnd;
        }

        // set child node
        public void addSubNode(Character c, TrieNode node) {
            subNodes.put(c, node);
        }

        // get child node
        public TrieNode getSubNode(Character c) {
            return subNodes.get(c);
        }
    }
}
