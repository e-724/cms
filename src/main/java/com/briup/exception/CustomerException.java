package com.briup.exception;

/**
 * @program: estore
 * @description: 自定义异常
 * @author: wangzh
 *
 **/

public class CustomerException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
     * 状态码
     */
    private Integer code;

	private String string;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public CustomerException(Integer code, String message){
        super(message);
        this.code = code;
    }

	public void setMessage(String string) {
		// TODO Auto-generated method stub
		this.string=string;
	}
}
