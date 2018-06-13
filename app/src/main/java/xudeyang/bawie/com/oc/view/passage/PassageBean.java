package xudeyang.bawie.com.oc.view.passage;

import java.util.List;

/**
 * Created by 怪胎 on 2018.6.11.
 */

public class PassageBean {

    /**
     * code : 0
     * data : [{"content":"nnnn","createTime":"2018-06-11T08:40:39","jid":2803,"uid":13550,"user":{"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1528715975136aaaa.jpg","nickname":"仅此而已","praiseNum":"null"}},{"content":"我是萌宝还是小仓鼠","createTime":"2018-06-11T08:33:28","jid":2802,"uid":15301,"user":{"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1528703758775head.png","nickname":"娃娃菜","praiseNum":"null"}},{"content":"1749","createTime":"2018-06-11T08:32:43","jid":2801,"uid":13850,"user":{"fans":"null","follow":false,"praiseNum":"null"}},{"content":"heool","createTime":"2018-06-11T08:31:48","jid":2800,"uid":13550,"user":{"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1528715975136aaaa.jpg","nickname":"仅此而已","praiseNum":"null"}},{"content":"Hello","createTime":"2018-06-11T08:27:59","jid":2799,"uid":13550,"user":{"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1528715975136aaaa.jpg","nickname":"仅此而已","praiseNum":"null"}},{"content":"好神奇的一件事","createTime":"2018-06-11T08:20:14","jid":2798,"uid":15301,"user":{"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1528703758775head.png","nickname":"娃娃菜","praiseNum":"null"}},{"content":"仅此唯一","createTime":"2018-06-11T08:17:40","jid":2797,"uid":13550,"user":{"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1528715975136aaaa.jpg","nickname":"仅此而已","praiseNum":"null"}},{"content":"心若改变，你的态度跟着改变；态度改变，你的习惯跟着改变；习惯改变，你的性格跟着改变；性格改变，你的人生跟着改变。","createTime":"2018-06-11T08:11:12","jid":2796,"uid":13900,"user":{"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1527749202994crop_image.jpg","nickname":"丿Swilder","praiseNum":"null"}},{"content":"请输入内容","createTime":"2018-06-11T08:08:20","jid":2795,"uid":15285,"user":{"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15287055187921512R.jpeg","nickname":"哇塞","praiseNum":"null"}},{"content":"那你","createTime":"2018-06-11T08:03:07","jid":2794,"uid":13550,"user":{"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1528715975136aaaa.jpg","nickname":"仅此而已","praiseNum":"null"}}]
     * msg : 获取段子列表成功
     */

    private String code;
    private String msg;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * content : nnnn
         * createTime : 2018-06-11T08:40:39
         * jid : 2803
         * uid : 13550
         * user : {"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1528715975136aaaa.jpg","nickname":"仅此而已","praiseNum":"null"}
         */

        private String content;
        private String createTime;
        private int jid;
        private int uid;
        private UserBean user;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1528715975136aaaa.jpg
             * nickname : 仅此而已
             * praiseNum : null
             */

            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
