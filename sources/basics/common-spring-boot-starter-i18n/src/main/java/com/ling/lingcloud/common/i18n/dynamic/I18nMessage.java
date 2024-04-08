package com.ling.lingcloud.common.i18n.dynamic;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


/**
 * 对标于 message bundle 的文件消息的抽象
 *
 * @author hccake
 */
@Data
public class I18nMessage {

	/**
	 * 国际化标识
	 */
	@NotEmpty(message = "{common.i18n.code}")
	private String code;

	/**
	 * 消息
	 */
	@NotEmpty(message = "{i18nMessage.message}")
	private String message;

	/**
	 * 地区语言标签
	 */
	@NotEmpty(message = "{i18nMessage.languageTag}")
	private String languageTag;

}
