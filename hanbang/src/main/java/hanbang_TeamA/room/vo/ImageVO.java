package hanbang_TeamA.room.vo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="image")
public class ImageVO {
	
		 private String seqId;
		 private String url;
		 private String caption;
		 private String type;
		 private String size;
		 private String data;
		public String getSeqId() {
			return seqId;
		}
		public void setSeqId(String seqId) {
			this.seqId = seqId;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getCaption() {
			return caption;
		}
		public void setCaption(String caption) {
			this.caption = caption;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		@Override
		public String toString() {
			return "ImageVO [seqId=" + seqId + ", url=" + url + ", caption="
					+ caption + ", type=" + type + ", size=" + size + ", data="
					+ data + "]";
		}
		 
}
