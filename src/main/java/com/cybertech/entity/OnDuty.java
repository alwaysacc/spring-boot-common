package com.cybertech.entity;

import lombok.*;

/**
 * ${DESCRIPTION}
 *
 * @author wuxw
 * @date 2018/12/24. 4:28 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnDuty {

	@Setter @Getter
	private String user_id;
	@Setter @Getter
	private String userName;
	@Setter @Getter
	private String jgbm;
	@Setter @Getter
	private String dbld;
	@Setter @Getter
	private String duty_date;
}
