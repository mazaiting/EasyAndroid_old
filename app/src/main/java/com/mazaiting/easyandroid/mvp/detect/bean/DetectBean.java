package com.mazaiting.easyandroid.mvp.detect.bean;

import java.util.List;

/**
 * 人脸检测JavaBean
 * @author mazaiting
 * @date 2018/2/6
 */

public class DetectBean {

    /**
     * image_id : wVs9JrFrZTQ25ApM/DMARw==
     * request_id : 1517909826,4d27b9ce-160e-46b8-9ef0-aa5693740baa
     * time_used : 398
     * faces : [{"face_rectangle":{"width":127,"top":341,"left":63,"height":127},"face_token":"510205ee70cf53f7d8017402f9af4a28"},{"face_rectangle":{"width":113,"top":60,"left":922,"height":113},"face_token":"29bb737f3d63f1782368bd676e507eda"},{"face_rectangle":{"width":108,"top":418,"left":423,"height":108},"face_token":"b205374978ee8d3b21d002149d130df6"},{"face_rectangle":{"width":107,"top":77,"left":632,"height":107},"face_token":"baea2e32d6807f0a4fb2e08a082cad35"},{"face_rectangle":{"width":87,"top":80,"left":378,"height":87},"face_token":"e01240c61566bcc7978fc04e1da7e840"},{"face_rectangle":{"width":85,"top":127,"left":98,"height":85},"face_token":"2cb1de6f3e2c9bcadb30e17ec49c7469"}]
     */

    private String image_id;
    private String request_id;
    private int time_used;
    private List<FacesBean> faces;

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public int getTime_used() {
        return time_used;
    }

    public void setTime_used(int time_used) {
        this.time_used = time_used;
    }

    public List<FacesBean> getFaces() {
        return faces;
    }

    public void setFaces(List<FacesBean> faces) {
        this.faces = faces;
    }

    public static class FacesBean {
        /**
         * face_rectangle : {"width":127,"top":341,"left":63,"height":127}
         * face_token : 510205ee70cf53f7d8017402f9af4a28
         */

        private FaceRectangleBean face_rectangle;
        private String face_token;

        public FaceRectangleBean getFace_rectangle() {
            return face_rectangle;
        }

        public void setFace_rectangle(FaceRectangleBean face_rectangle) {
            this.face_rectangle = face_rectangle;
        }

        public String getFace_token() {
            return face_token;
        }

        public void setFace_token(String face_token) {
            this.face_token = face_token;
        }

        public static class FaceRectangleBean {
            /**
             * width : 127
             * top : 341
             * left : 63
             * height : 127
             */

            private int width;
            private int top;
            private int left;
            private int height;

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public int getLeft() {
                return left;
            }

            public void setLeft(int left) {
                this.left = left;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            @Override
            public String toString() {
                return "FaceRectangleBean{" +
                        "width=" + width +
                        ", top=" + top +
                        ", left=" + left +
                        ", height=" + height +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "FacesBean{" +
                    "face_rectangle=" + face_rectangle +
                    ", face_token='" + face_token + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "DetectBean{" +
                "image_id='" + image_id + '\'' +
                ", request_id='" + request_id + '\'' +
                ", time_used=" + time_used +
                ", faces=" + faces +
                '}';
    }
}
