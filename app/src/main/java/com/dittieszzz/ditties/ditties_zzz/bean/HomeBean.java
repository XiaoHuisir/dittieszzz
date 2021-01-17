package com.dittieszzz.ditties.ditties_zzz.bean;

import java.util.List;

public class HomeBean {

    private List<MainPoemsListBean> mainPoemsList;

    public List<MainPoemsListBean> getMainPoemsList() {
        return mainPoemsList;
    }

    public void setMainPoemsList(List<MainPoemsListBean> mainPoemsList) {
        this.mainPoemsList = mainPoemsList;
    }

    public static class MainPoemsListBean {
        /**
         * id : 5c22086397880d3b825c95f1
         * onlyId : 9986bd384e13918ad0d9033e80ab4ad9
         * name : 终南望余雪
         * dynasty : 唐代
         * author : 祖咏
         * sourceLink : https://so.gushiwen.org/shiwenv_038457ce8c4e.aspx
         * type : 唐诗三百首
         * format : 五言绝句
         * content : 终南阴岭秀，积雪浮云端。林表明霁色，城中增暮寒。
         * translate : 遥望终南，北山秀丽，皑皑白雪，若浮云间。雪后初晴，林梢之间闪烁着夕阳余晖，晚时分，长安城内又添了几分积寒。
         * translate_res : 彭定求 等．全唐诗（上）．上海：上海古籍出版社，1986：6于海娣 等．唐诗鉴赏大全集．北京：中国华侨出版社，21：58张国举 等．唐诗精华注译评．长春：长春出版社，21：95-96
         * tags : 唐诗三百首,冬天,写景,写雪
         * notes : 终南阴岭秀，积雪浮云端。终南：山名，在唐京城长安（今陕西西安）南面六十里处。余雪：指未融化之雪。阴岭：北面的山岭，背向太阳，故曰阴。林表明霁(jì)色，城中增暮寒。 林表：林外，林梢。霁：雨、雪后天气转晴。
         * reference :
         * appreciation :
         * appreciation_res :
         */

        private String id;
        private String onlyId;
        private String name;
        private String dynasty;
        private String author;
        private String sourceLink;
        private String type;
        private String format;
        private String content;
        private String translate;
        private String translate_res;
        private String tags;
        private String notes;
        private String reference;
        private String appreciation;
        private String appreciation_res;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOnlyId() {
            return onlyId;
        }

        public void setOnlyId(String onlyId) {
            this.onlyId = onlyId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDynasty() {
            return dynasty;
        }

        public void setDynasty(String dynasty) {
            this.dynasty = dynasty;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getSourceLink() {
            return sourceLink;
        }

        public void setSourceLink(String sourceLink) {
            this.sourceLink = sourceLink;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTranslate() {
            return translate;
        }

        public void setTranslate(String translate) {
            this.translate = translate;
        }

        public String getTranslate_res() {
            return translate_res;
        }

        public void setTranslate_res(String translate_res) {
            this.translate_res = translate_res;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public String getAppreciation() {
            return appreciation;
        }

        public void setAppreciation(String appreciation) {
            this.appreciation = appreciation;
        }

        public String getAppreciation_res() {
            return appreciation_res;
        }

        public void setAppreciation_res(String appreciation_res) {
            this.appreciation_res = appreciation_res;
        }
    }
}
