package springcloud.client.model;

public class BaseDataModel {

	private Integer page;
	private Integer rows;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public static class ResponseDataModel {

		public final static String SUCCESS = "ok";
		public final static String NOT_SUCCESS = "fail";
		public static ResponseDataModel RESPONSE_ERROR_DATA_MODEL;
		public static ResponseDataModel RESPONSE_SUCCESS_DATA_MODEL;
		public static ResponseDataModel RESPONSE_ADD_TASK_SUCCESS_DATA_MODEL;
		static {
			RESPONSE_ERROR_DATA_MODEL = new ResponseDataModel(false, "操作异常！");
			RESPONSE_SUCCESS_DATA_MODEL = new ResponseDataModel(true, "执行成功！");

			RESPONSE_ADD_TASK_SUCCESS_DATA_MODEL = new ResponseDataModel(true, "成功添加任务！");
		}
		private String msg;

		private String result;

		public ResponseDataModel(boolean success, String msg) {
			if (success) {
				this.result = SUCCESS;
			} else {
				this.result = NOT_SUCCESS;
			}
			this.msg = msg;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}

	}
}
