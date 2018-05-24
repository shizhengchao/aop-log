package com.szc.blog.aop.message;

/**
 * @author hz17052992
 * @date 2017年12月22日 下午5:19:34
 * @version
 */
public class Message {

	public static final String OK_MESSAGE_CODE = "0000";
	public static final String ERROR_MESSAGE_CODE = "-1";

	// Response

	private String errorCode;

	private String errorMessage;

	private Object data;

	protected Message() {

	}

	protected Message(String errorCode, String errorMessage, Object data) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.data = data;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Object getData() {
		return data;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 无结果的成功返回
	 * 
	 * @return
	 * 
	 * @author hz17052992
	 * @date 2017年12月22日 下午5:48:38
	 * @version
	 */
	public static MessageBuilder ok() {
		MessageBuilder builder = status(OK_MESSAGE_CODE);
		builder.errorMessage("success");
		return builder;

	}

	/**
	 * 有结果的成功返回
	 * 
	 * @param data
	 * @return
	 * 
	 * @author hz17052992
	 * @date 2017年12月22日 下午5:54:50
	 * @version
	 */
	public static MessageBuilder ok(Object data) {
		MessageBuilder builder = ok();
		builder.data(data);
		return builder;
	}

	/**
	 * 
	 * @return
	 * 
	 * @author hz17052992
	 * @date 2017年12月22日 下午5:56:00
	 * @version
	 */
	public static MessageBuilder error() {
		MessageBuilder builder = status(ERROR_MESSAGE_CODE);
		return builder;
	}

	public static MessageBuilder error(String errorMessage) {
		MessageBuilder builder = error();
		builder.errorMessage(errorMessage);
		return builder;
	}

	public static MessageBuilder status(String errorCode) {
		MessageBuilder builder = new MessageBuilder();
		builder.errorCode(errorCode);
		return builder;
	}

	public static class MessageBuilder {

		private String errorCode;

		private String errorMessage;

		private Object data;

		protected MessageBuilder() {
		}

		public MessageBuilder errorCode(String errorCode) {
			this.errorCode = errorCode;
			return this;
		}

		public MessageBuilder errorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
			return this;
		}

		public MessageBuilder data(Object data) {
			this.data = data;
			return this;
		}

		public Message build() {
			return new Message(errorCode, errorMessage, data);
		}
	}
}
