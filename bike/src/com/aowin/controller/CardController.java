package com.aowin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.aowin.model.Card;
import com.aowin.model.Card_Record;
import com.aowin.page.Page;
import com.aowin.service.CardService;
import com.aowin.service.impl.CardServiceImpl;
//error 需要放在session里
@Controller
@SessionAttributes({ "error" })
public class CardController {
	@Autowired
	private CardService cardService;
	@RequestMapping(value = "/datalist")
	public ModelAndView dataListService(Integer currentPage,
			@RequestParam() Map<String, String> queryMap) {
		ModelAndView mav = new ModelAndView();
		System.out.println(currentPage + "" + queryMap);
		try {
			Page<Card> page = cardService.selectPage(currentPage, queryMap);
			mav.addObject("page", page);
			mav.setViewName("/main.jsp");
		} catch (Exception e) {
			mav.addObject("error", e.getMessage());
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/searchCard")
	public ModelAndView searchCardService(String card_code) {
		ModelAndView mav = new ModelAndView();
		try {
			Card card = cardService.Search(card_code);
			mav.addObject("result", card);
			System.out.println(card.getName() + "****************8");
			mav.setViewName("/updateCard.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/main.jsp");
			mav.addObject("error", e.getMessage());
		}
		return mav;

	}

	@RequestMapping(value = "/insertCard")
	public ModelAndView insertCardService(String card_code, String kind,
			String name, String idcard, String sex, String telphone,
			String mobile, String email, String address, String work) {
		ModelAndView mav = new ModelAndView();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		String createdate = dateFormat.format(date);
		Integer card_type = 0;
		System.out.println(kind + "&&&&" + sex);
		if (kind.equals("ACard")) {
			card_type = 1;
		} else if (kind.equals("DCard")) {
			card_type = 2;
		} else if (kind.equals("CSCard")) {
			card_type = 3;
		} else if (kind.equals("employeeCard")) {
			card_type = 4;
		} else if (kind.equals("transferCard")) {
			card_type = 5;

		}
		if (sex.equals("male"))
			sex = "1";
		else
			sex = "0";
		String remark = "新增卡";
		try {
			System.out.println(card_type + "&&&&" + sex + "******");
			int i = cardService.insertCard(card_code, card_type, name, idcard,
					sex, telphone, mobile, email, address, work, createdate,
					remark);
			if (i != 2) {
				System.out.println("数据同步增加失败");
			}
			mav.setViewName("/main.jsp");

		} catch (Exception e) {
			mav.addObject("error", e.getMessage());
			e.printStackTrace();
		}
		return mav;

	}

	@RequestMapping(value = "/updateCard")
	public ModelAndView updateCardService(String card_code, String kind,
			String name, String idcard, String sex, String telphone,
			String mobile, String email, String address, String work) {
		ModelAndView mav = new ModelAndView();

		Integer card_type = 0;
		System.out.println(kind + "&&&&" + sex);
		if (kind.equals("ACard")) {
			card_type = 1;
		} else if (kind.equals("DCard")) {
			card_type = 2;
		} else if (kind.equals("citizenCard")) {
			card_type = 3;
		} else if (kind.equals("socialSecurity")) {
			card_type = 3;
		} else if (kind.equals("employeeCard")) {
			card_type = 4;
		} else if (kind.equals("transferCard")) {
			card_type = 5;

		}
		if (sex.equals("male"))
			sex = "1";
		else
			sex = "0";

		try {
			System.out.println(card_type + "&&&&" + sex + "******");
			int i = cardService.updateCard(card_code, card_type, name, idcard,
					sex, telphone, mobile, email, address, work);
			if (i != 2) {
				System.out
						.println("数据同步增加失败&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			}
			mav.setViewName("/main.jsp");

		} catch (Exception e) {
			mav.addObject("error", e.getMessage());
			e.printStackTrace();
		}
		return mav;

	}

	@RequestMapping(value = "/lossCard")
	public ModelAndView lossCardService(String card_code) {
		ModelAndView mav = new ModelAndView();
		try {
			int i = cardService.reportLoss(card_code);
			System.out.println(i);
			if (i != 2) {
				System.out
						.println("数据同步增加失败&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			}
			mav.setViewName("/main.jsp");
		} catch (Exception e) {
			mav.addObject("error", e.getMessage());
			e.printStackTrace();

		}
		return mav;

	}

	@RequestMapping(value = "/logOffCard")
	public ModelAndView logOffCardService(String card_code, String reason) {
		ModelAndView mav = new ModelAndView();
		try {
			int i = cardService.logOff(card_code, reason);
			if (i != 3) {
				System.out.println("数据同步不成功");
			}

			mav.setViewName("/main.jsp");
		} catch (Exception e) {
			mav.addObject("error", e.getMessage());
			e.getMessage();
		}
		return mav;
	}
//每次首充月票算法
	@RequestMapping(value = "/recharge")
	public ModelAndView rechargeService(String fee_type, String amount, String card_code) {
		ModelAndView mav = new ModelAndView();
		try {
			
			int i = 0;
			if (Double.parseDouble(amount) < 50.0) {
				System.out.println("充值金额小于50元进行判断");
				System.out.println(card_code);
				Card card = cardService.Search(card_code);
				Card_Record record = cardService.searchRecharge(card.getCard_id());
System.out.println(record);
				// 只有当有记录查到的时候才需要判断日期，没有记录查到必定要充值50以上
				if (record != null) {
					System.out.println(record);
					System.out.println("查询到充值记录");
					String create_date = record.getCreate_time();
					int year = Integer.parseInt(create_date.substring(0, 4));
					int month = Integer.parseInt(create_date.substring(5, 7));
					int day = Integer.parseInt(create_date.substring(8, 10));
					SimpleDateFormat dateFormat = new SimpleDateFormat(
							"yyyy/MM/dd HH:mm:ss");
					String sysdate = dateFormat.format(new Date());
					int sysyear = Integer.parseInt(sysdate.substring(0, 4));
					int sysmonth = Integer.parseInt(sysdate.substring(5, 7));
					int sysday = Integer.parseInt(sysdate.substring(8, 10));
					/*
					 * 判断同年分 的情况。 同月份的充值一定通过验证 不同月份只有系统时间超记录时间一个月且
					 * 系统日期小于记录时间才通过验证
					 */
					if (year == sysyear) {
						System.out.println("与上次充值记录同年分");
						if (month == sysmonth) {
							System.out.println("与上次充值记录同月分");
							i = cardService.recharge(
									Double.parseDouble(amount), fee_type,
									card_code);
							mav.setViewName("/main.jsp");
						} else if (month != sysmonth) {
							if (sysmonth - month == 1) {
								System.out.println("与上次充值记录只相差一个月");
								if (sysday <= day) {
									System.out
											.println("与上次充值记录相差一个月不到，可以充值少于50的金额");
									i = cardService.recharge(
											Double.parseDouble(amount),
											fee_type, card_code);
									mav.setViewName("/main.jsp");
								} else {
									mav.addObject("error",
											"距离上次充值50元以上已超过一个月，请充值50以上");
									mav.setViewName("/main.jsp");
								}
							} else {
								mav.addObject("error",
										"距离上次充值50元以上已超过一个月，请充值50以上");
								mav.setViewName("/main.jsp");
							}
						}

					}
					// 判断不同年份的情况。 只有系统年份超记录年份
					// 1年且系统月份为1月，而记录月份为12月，并且系统日期不超过记录日期，
					// 才会会是少于一个月的情况
					else if (year != sysyear) {
						if (sysyear - year == 1) {
							if (month == 12 && sysmonth == 1) {
								if (sysday <= day) {
									i = cardService.recharge(
											Double.parseDouble(amount),
											fee_type, card_code);
									mav.setViewName("/main.jsp");
								}
							} else {
								mav.addObject("error",  
										"距离上次充值50元以上已超过一个月，请充值50以上");
								mav.setViewName("/main.jsp");
							}//这里不知道为什么不能加error

						} else {
							mav.addObject("error", "距离上次充值50元以上已超过一个月，请充值50以上");
							mav.setViewName("/main.jsp");
						}
					}

				} else {
					System.out.println("错误");
					mav.addObject("error", "首充必须大于或等于50元");
					mav.setViewName("/main.jsp");
				}

			} else {
				System.out.println(amount+"***************************");
				i = cardService.recharge(Double.parseDouble(amount), fee_type,
						card_code);
				if (i != 2) {
					System.out.println("数据同步增加失败");
				}
				System.out.println("%%%%%%%%%%%%%%%%%%%%");
				mav.setViewName("/main.jsp");

			}
		} catch (Exception e) {

			mav.addObject("error", e.getMessage());
			e.getMessage();
		}
		return mav;
	}
}
