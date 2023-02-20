package com.nowcoder.community.util;

public interface CommunityConstant {

    /**
     * active successfully
     */
    int ACTIVATION_SUCCESS = 0;

    /**
     * repeat activation
     */
    int ACTIVATION_REPEAT = 1;

    /**
     * activation fail
     */
    int ACTIVATION_FAILURE = 2;

    /**
     * default expired time of login token
     */
    int DEFAULT_EXPIRED_SECONDS = 3600 * 12;

    /**
     * expired time of login token when "remember me" checked
     */
    int REMEMBER_EXPIRED_SECONDS = 3600 * 24 * 30;

    /**
     * Entity Type: Post
     */
    int ENTITY_TYPE_POST = 1;

    /**
     * Entity Type: Comment
     */
    int ENTITY_TYPE_COMMENT = 2;

    /**
     * Entity Type: User
     */
    int ENTITY_TYPE_USER = 3;

    /**
     * Subject: Comments
     */
    String TOPIC_COMMENT = "comment";

    /**
     * Subject: like
     */
    String TOPIC_LIKE = "like";

    /**
     * Subject: follow
     */
    String TOPIC_FOLLOW = "follow";

    /**
     * Subject: post
     */
    String TOPIC_PUBLISH = "publish";

    /**
     * Subject: delete post
     */
    String TOPIC_DELETE = "delete";

    /**
     * System user ID
     */
    int SYSTEM_USER_ID = 1;

    /**
     * AUTHORITY: normal user
     */
    String AUTHORITY_USER = "user";

    /**
     * AUTHORITY: admin
     */
    String AUTHORITY_ADMIN = "admin";

    /**
     * AUTHORITY: moderator
     */
    String AUTHORITY_MODERATOR = "moderator";
}
