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
     * 实体类型: 帖子
     */
    int ENTITY_TYPE_POST = 1;

    /**
     * 实体类型: 评论
     */
    int ENTITY_TYPE_COMMENT = 2;

    /**
     * 实体类型: 用户
     */
    int ENTITY_TYPE_USER = 3;

    /**
     * 主题: 评论
     */
    String TOPIC_COMMENT = "comment";

    /**
     * 主题: 点赞
     */
    String TOPIC_LIKE = "like";

    /**
     * 主题: 关注
     */
    String TOPIC_FOLLOW = "follow";

    /**
     * 系统用户ID
     */
    int SYSTEM_USER_ID = 1;
}
