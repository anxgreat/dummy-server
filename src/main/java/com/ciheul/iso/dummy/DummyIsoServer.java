package com.ciheul.iso.dummy;

import java.io.IOException;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOServer;
import org.jpos.iso.ISOSource;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.ServerChannel;
import org.jpos.iso.packager.ISO87APackager;
import org.jpos.util.LogSource;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;

import com.ciheul.iso.channel.AJChannel;

public class DummyIsoServer implements ISORequestListener {
	public static String ECHO_REQ = "0800";
	public static String ECHO_RES = "0810";
	public static String TRX_REQ = "0200";
	public static String REV_REQ = "0400";

	private static int SUCCESS = 0;
	private static int FAIL = -1;

	// please change the status when necessary for debugging "checking status" flow
	private static int ADVICE_STATUS = FAIL;

	public DummyIsoServer() {
		super();
	}

	public static void logISOMsg(ISOMsg msg) {
		System.out.println("----ISO MESSAGE-----");
		try {
			System.out.println("  MTI : " + msg.getMTI());
			for (int i = 1; i <= msg.getMaxField(); i++) {
				if (msg.hasField(i)) {
					System.out.println("    Field-" + i + " : " + msg.getString(i));
				}
			}
		} catch (ISOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("--------------------");
		}
	}

	/**
	 * Send echo test response.
	 * 
	 * @param source
	 *            (Artajasa) channel
	 * @param m
	 *            message from client
	 */
	private void sendEchoTestResponse(ISOSource source, ISOMsg m) {
		System.out.println("sendEchoResponse");
		// try {
		// Thread.sleep(10000); // 1000 milliseconds is one second.
		// } catch (InterruptedException ex) {
		// Thread.currentThread().interrupt();
		// }
		// ISOUtil.sleep(20000);

		try {
			m.setResponseMTI();
			m.set(39, "00");
			m.set(70, "001");
			m.setPackager(new ISO87APackager());
			logISOMsg(m);
			source.send(m);
		} catch (ISOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Send sign-on response.
	 * 
	 * @param source
	 *            (Artajasa) channel
	 * @param m
	 *            message from client
	 */
	private void sendSignOnResponse(ISOSource source, ISOMsg m) {
		System.out.println("sendSignOnResponse");
		try {
			m.set(39, "00");
			m.set(70, "001");
			m.setPackager(new ISO87APackager());
			source.send(m);
		} catch (ISOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Send inquiry postpaid response.
	 * 
	 * @param source
	 *            (Artajasa) channel
	 * @param m
	 *            message from client
	 */
	private void sendInquiryPostpaid(ISOSource source, ISOMsg m) {
		System.out.println("sendInquiryPostpaid");
		try {
			m.setResponseMTI();
			m.set(39, "00");
			
			if (m.getString(48).substring(4, 16).equals("121234567890")) {
				m.set(48,
						"2112121234567890 101YZ012343210ZYXWXVW0VWX0W4X1XW342                                NAMA BIN NAMA                 12345021            R1  12345678900000250000000015000003602009012009021520090101000000150000D00000000000000001500000001000000010000000200000001000000020000000100000002000");
			}
			
			
			if (m.getString(48).substring(4, 16).equals("121234567891")) {
				m.set(48,
						"2112121234567891 101YZ012343210ZYXWXVW0VWX0W4X1XW342                                JOKO SUKANKO                  12345021            R1  12345678900000250000000015000003602009012009021520090101000000150000D00000000000000001500000001000000010000000200000001000000020000000100000002000");
			}
			
			if (m.getString(48).substring(4, 16).equals("121234567892")) {
				m.set(48,
						"2112121234567892 101YZ012343210ZYXWXVW0VWX0W4X1XW342                                MINAH SUMINAH                 12345021            R1  12345678900000250000000015000003602009012009021520090101000000150000D00000000000000001500000001000000010000000200000001000000020000000100000002000");
			}
			
			if (m.getString(48).substring(4, 16).equals("121234567893")) {
				m.set(48,
						"2112121234567893 101YZ012343210ZYXWXVW0VWX0W4X1XW342                                MINI RUKMINI                  12345021            R1  12345678900000250000000015000003602009012009021520090101000000150000D00000000000000001500000001000000010000000200000001000000020000000100000002000");
			}
			
			if (m.getString(48).substring(4, 16).equals("121234567894")) {
				m.set(48,
						"2112121234567894 101YZ012343210ZYXWXVW0VWX0W4X1XW342                                MINEM TUKINEM                 12345021            R1  12345678900000250000000015000003602009012009021520090101000000150000D00000000000000001500000001000000010000000200000001000000020000000100000002000");
			}
			
			if (m.getString(48).substring(4, 16).equals("121234567895")) {
				m.set(48,
						"2112121234567895 101YZ012343210ZYXWXVW0VWX0W4X1XW342                                IJAH MARIJAH                  12345021            R1  12345678900000250000000015000003602009012009021520090101000000150000D00000000000000001500000001000000010000000200000001000000020000000100000002000");
			}
			
			if (m.getString(48).substring(4, 16).equals("121234567896")) {
				m.set(48,
						"2112121234567896 101YZ012343210ZYXWXVW0VWX0W4X1XW342                                MAT KARYO                     12345021            R1  12345678900000250000000015000003602009012009021520090101000000150000D00000000000000001500000001000000010000000200000001000000020000000100000002000");
			}
			
			if (m.getString(48).substring(4, 16).equals("547101190654")) {
				m.set(48, "2112547101190654 2029XWZAXA82W43Z2W6550W9950Z995WA0Z                                DRA FANNY FRANCISKA           54740123              R100000090000000000000000025122203602015122012201500000000000000121364D000000000000000000000000060000362770003649300000000000000000000000000000000002016012001201600000000000000120858D00000000000000000000000003000036493000367080000000000000000000000000000000000");
			}
			// m.set(48,
			// "2112131234561111 404KGIM9AVVVVVV3XVZ20XVWZWXWWV4W4W0 AZHAR WAHYU' S.T,M-T SU001021-98765432 R1
			// 00000130000000000000000020000003602014012014012020140102000000050000D000001111100000011110000000000000010000000200000000000000000000000000000000002014022014022020140202000000050000D000002222200000022220000000000000010000000200000000000000000000000000000000002014032014032000000000000000050000D000003333300000033330000000000000010000000200000000000000000000000000000000002014042014032000000000000000050000D00000444440000004444000000000000001000000020000000000000000000000000000000000");

			m.setPackager(new ISO87APackager());
			m.setDirection(ISOMsg.OUTGOING);
			source.send(m);
		} catch (ISOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Send payment postpaid response.
	 * 
	 * @param source
	 *            (Artajasa) channel
	 * @param m
	 *            message from client
	 */
	private void sendPaymentPostpaid(ISOSource source, ISOMsg m) {
		// try {
		// Thread.sleep(15000); // 1000 milliseconds is one second.
		// } catch (InterruptedException ex) {
		// Thread.currentThread().interrupt();
		// }
		// ISOUtil.sleep(15000);
		System.out.println("sendPaymentPostpaid");
		try {
			m.setResponseMTI();
			m.set(39, "00");
//			m.set(48,
//					"2112121234567890 1101YZ012343210ZYXWXVW0VWX0W4X1XW342                                NAMA BIN NAMA                 12345021            R1  12345678900000250000000015000003602009012009021520090101000000150000D00000000000000001500000001000000010000000200000001000000020000000100000002000");

			if (m.getString(48).substring(4, 16).equals("121234567890")) {
				m.set(48,
						"2112121234567890 1101YZ012343210ZYXWXVW0VWX0W4X1XW342                                NAMA BIN NAMA                 12345021            R1  12345678900000250000000015000003602009012009021520090101000000150000D00000000000000001500000001000000010000000200000001000000020000000100000002000");
			}
			
			if (m.getString(48).substring(4, 16).equals("121234567891")) {
				m.set(48,
						"2112121234567891 1101YZ012343210ZYXWXVW0VWX0W4X1XW342                                JOKO SUKANKO                  12345021            R1  12345678900000250000000015000003602009012009021520090101000000150000D00000000000000001500000001000000010000000200000001000000020000000100000002000");
			}
			
			if (m.getString(48).substring(4, 16).equals("121234567892")) {
				m.set(48,
						"2112121234567892 1101YZ012343210ZYXWXVW0VWX0W4X1XW342                                MINAH SUMINAH                 12345021            R1  12345678900000250000000015000003602009012009021520090101000000150000D00000000000000001500000001000000010000000200000001000000020000000100000002000");
			}
			
			if (m.getString(48).substring(4, 16).equals("121234567893")) {
				m.set(48,
						"2112121234567893 1101YZ012343210ZYXWXVW0VWX0W4X1XW342                                MINI RUKMINI                  12345021            R1  12345678900000250000000015000003602009012009021520090101000000150000D00000000000000001500000001000000010000000200000001000000020000000100000002000");
			}
			
			if (m.getString(48).substring(4, 16).equals("121234567894")) {
				m.set(48,
						"2112121234567894 1101YZ012343210ZYXWXVW0VWX0W4X1XW342                                MINEM TUKINEM                 12345021            R1  12345678900000250000000015000003602009012009021520090101000000150000D00000000000000001500000001000000010000000200000001000000020000000100000002000");
			}
			
			if (m.getString(48).substring(4, 16).equals("121234567895")) {
				m.set(39, "91");
				m.set(48,
						"2112121234567895 1101YZ012343210ZYXWXVW0VWX0W4X1XW342                                IJAH MARIJAH                  12345021            R1  12345678900000250000000015000003602009012009021520090101000000150000D00000000000000001500000001000000010000000200000001000000020000000100000002000");
			}
			
			if (m.getString(48).substring(4, 16).equals("121234567896")) {
				m.set(39, "68");
				m.set(48,
						"2112121234567896 1101YZ012343210ZYXWXVW0VWX0W4X1XW342                                MAT KARYO                     12345021            R1  12345678900000250000000015000003602009012009021520090101000000150000D00000000000000001500000001000000010000000200000001000000020000000100000002000");
			}
			
			if (m.getString(48).substring(4, 16).equals("547101190654")) {
				m.set(48, "2112547101190654 22029XWZAXA82W43Z2W6550W9950Z995WA0Z                                DRA FANNY FRANCISKA           54740123              R100000090000000000000000025122203602015122012201500000000000000121364D000000000000000000000000060000362770003649300000000000000000000000000000000002016012001201600000000000000120858D00000000000000000000000003000036493000367080000000000000000000000000000000000");
			}
			
			// m.set(48,
			// "2112131234561111 4404KGIM9AVVVVVV3XVZ20XVWZWXWWV4W4W0 AZHAR WAHYU' S.T,M-T SU001021-98765432 R1
			// 00000130000000000000000020000003602014012014012020140102000000050000D000001111100000011110000000000000010000000200000000000000000000000000000000002014022014022020140202000000050000D000002222200000022220000000000000010000000200000000000000000000000000000000002014032014032000000000000000050000D000003333300000033330000000000000010000000200000000000000000000000000000000002014042014032000000000000000050000D00000444440000004444000000000000001000000020000000000000000000000000000000000");

			m.setPackager(new ISO87APackager());
			source.send(m);
		} catch (ISOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Send inquiry prepaid response.
	 * 
	 * @param source
	 *            (Artajasa) channel
	 * @param m
	 *            message from client
	 */
	private void sendInquiryPrepaid(ISOSource source, ISOMsg m) {
		System.out.println("sendInquiryPrepaid");
		try {
			m.setResponseMTI();
			m.set(39, "00");
			// m.set(48,
			// "211112345671111131234533301 0AZHAR WAHYU' S.T,M-T R1 000002200DCSUNITSUPHONE123
			// 1000020000010000000000200000KGIM9AVVVVVVVVVZ4YXVW0VWX3W0VXX4 360003214");

			m.set(48,
					"211134035190445311010406195 0JUNITA JULIANA KAREL     R1  0000022003131101123            0158400000000000000000000000827361WX4048ZYA6596ZX9ZY94ZY9XXV");
			m.setPackager(new ISO87APackager());
			source.send(m);
		} catch (ISOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Send inquiry postpaid response.
	 * 
	 * @param source
	 *            (Artajasa) channel
	 * @param m
	 *            message from client
	 */
	private void sendPaymentPrepaid(ISOSource source, ISOMsg m) {
		System.out.println("sendPaymentPrepaid");
		try {
			m.setResponseMTI();
			m.set(39, "68");
			// m.set(48,
			// "211112345673221131234561111 0AZHAR WAHYU' S.T,M-T R1 000002200DCSUNITSUPHONE123
			// 1000000000000000000000000000KGIM9AVVVVVVVVVVWXXVWZWXW4W0V3W0V00KF0000130217XCJF0PE001384
			// 0PVENDINGR000000000002000002002220000030033200000400442000555005520000666006661000055550012349874235472358811058Informasi
			// hubungi call center 123 atau hub.PLN terdekat : ");

			m.set(48,
					"211134035190445311010406195 0JUNITA JULIANA KAREL     R1  0000022003131101123            0158400000000000000000000000827361WX4048ZYA6596ZX9ZY94ZY9XXV073521V00KF41687966284763BC803070P00000000200000000002000000000020000000000200009091002000000000020000090909002000000673051122481121747103222060Informasi Hubungi Call Center 123 Atau hubungi PLN Terdekat");
			m.setPackager(new ISO87APackager());
			source.send(m);
		} catch (ISOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Send inquiry postpaid response.
	 * 
	 * @param source
	 *            (Artajasa) channel
	 * @param m
	 *            message from client
	 */
	private void sendReversal(ISOSource source, ISOMsg m) {
		System.out.println("sendReversal");
		try {
			m.setResponseMTI();
			m.set(39, "00");
			// m.set(48,
			// "21144567891230123000PENYAMBUNGAN BARU 2011062420111224531234563301 AZHAR WAHYU'B S.Pd,M-Pd
			// KGIM9AVVVVVV3XVZ20XVWZWXWWV4XXW1 SU001JL. RAYA 1 BOJONGGEDE 021-66655544
			// 00000200000003600000000000020000000000000000020000000000000000001200000000050000000");
			m.setPackager(new ISO87APackager());
			source.send(m);
		} catch (ISOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendInquiryNontaglis(ISOSource source, ISOMsg m) {
		System.out.println("sendInquiryPostpaid");
		try {
			m.setResponseMTI();
			m.set(39, "00");
			m.set(48,
					"21144567891230123000PENYAMBUNGAN BARU        2011062420111224531234563301 AZHAR WAHYU'B S.Pd,M-Pd       KGIM9AVVVVVV3XVZ20XVWZWXWWV4XXW1                                SU001JL. RAYA 1 BOJONGGEDE              021-66655544   00000200000003600000000000020000000000000000020000000000000000001200000000050000000");
			m.setPackager(new ISO87APackager());
			source.send(m);
		} catch (ISOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Send payment postpaid response.
	 * 
	 * @param source
	 *            (Artajasa) channel
	 * @param m
	 *            message from client
	 */
	private void sendPaymentNontaglis(ISOSource source, ISOMsg m) {
		System.out.println("sendInquiryPostpaid");
		try {
			m.setResponseMTI();
			m.set(39, "00");
			m.set(48,
					"21144567891230123000PENYAMBUNGAN BARU        2011062420111224531234563301 AZHAR WAHYU'B S.Pd,M-Pd       KGIM9AVVVVVV3XVZ20XVWZWXWWV4XXW1                                SU001JL. RAYA 1 BOJONGGEDE              021-66655544   00000200000003600000000000020000000000000000020000000000000000001200000000050000000");
			m.setPackager(new ISO87APackager());
			source.send(m);
		} catch (ISOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Send advice. If bit39==00, bit48 equals to bit48 when payment success. Otherwise, bit48 doesn't change.
	 */
	private void sendAdvice(ISOSource source, ISOMsg m) {
		try {
			m.setResponseMTI();
			if (ADVICE_STATUS == SUCCESS) {
				m.set(39, "00");
				m.set(48,
						"211112345673221131234561111 0AZHAR WAHYU' S.T,M-T     R1  000002200DCSUNITSUPHONE123     1000000000000000000000000000KGIM9AVVVVVVVVVVWXXVWZWXW4W0V3W0V00KF0000130217XCJF0PE001384    0PVENDINGR000000000002000002002220000030033200000400442000555005520000666006661000055550012349874235472358811058Informasi hubungi call center 123 atau hub.PLN terdekat : ");
			} else {
				m.set(39, "68");
			}
			m.setPackager(new ISO87APackager());
			source.send(m);
		} catch (ISOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Route incoming message to appropriate handler
	 * 
	 * @param source
	 *            (Artajasa) channel
	 * @param m
	 *            message from client
	 */
	public boolean process(ISOSource source, ISOMsg m) {
		System.out.println("received by process");
		// ISOUtil.sleep(1000);

		try {

			// echo test
			if (m.getMTI().equals(ECHO_REQ)) {
				sendEchoTestResponse(source, m);
				return true;
			}

			// sign on
			if (m.getMTI().equals(ECHO_RES)) {
				sendSignOnResponse(source, m);
				return true;
			}

			// reversal
			if (m.getMTI().equals(REV_REQ)) {
				sendReversal(source, m);
				return true;
			}

			// transaction
			if (m.getMTI().equals(TRX_REQ)) {
				String bit48 = m.getValue(48).toString();
				System.out.println("request is inq/pay transaction");
				// postpaid
				if (m.getValue(48).toString().substring(0, 4).equals("2112")) {
					// inquiry
					// ISOUtil.sleep(5000);
					if (m.getValue(3).toString().equals("380000")) {
						sendInquiryPostpaid(source, m);
						return true;
					}

					// payment
					if (m.getValue(3).toString().equals("180000")) {
						sendPaymentPostpaid(source, m);
						return true;
					}
				}

				// prepaid
				if (m.getValue(48).toString().substring(0, 4).equals("2111")) {
					System.out.println("request is prepaid");
					System.out.println("bit48  : " + bit48);
					System.out.println("prepaid: " + bit48.substring(bit48.length() - 1));

					// inquiry
					if (m.getValue(3).toString().equals("380000")) {
						// ISOUtil.sleep(5000);
						System.out.println("sendInquiryPrepaid");
						sendInquiryPrepaid(source, m);
						return true;
					}

					// payment
					// P000000000000000
					// 1 char = P
					// 25 chars = '0' * 25
					int idx = bit48.length() - (1 + 25);
					if (m.getValue(3).toString().equals("180000") && bit48.substring(idx, idx + 1).equals("P")) {
						System.out.println("before sendPaymentPrepaid");
						ISOUtil.sleep(60000);
						sendPaymentPrepaid(source, m);
						System.out.println("after sendPaymentPrepaid");
						return true;
					}

					// advice
					if (m.getValue(3).toString().equals("180000") && bit48.substring(idx, idx + 1).equals("A")) {
						System.out.println("sendAdvice");
						sendAdvice(source, m);
						return true;
					}
				}

				// nontaglis
				if (m.getValue(48).toString().substring(0, 4).equals("2114")) {

					if (m.getValue(3).toString().equals("380000")) {
						sendInquiryNontaglis(source, m);
						return true;
					}

					if (m.getValue(3).toString().equals("180000")) {
						sendPaymentNontaglis(source, m);
						return true;
					}
				}
			}
		} catch (ISOException e) {
			e.printStackTrace();
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		Logger logger = new Logger();
		logger.addListener(new SimpleLogListener(System.out));

		ServerChannel channel = new AJChannel(new ISO87APackager());
		((LogSource) channel).setLogger(logger, "channel");

		// 21735 => prepaid
		ISOServer prepaidServer = new ISOServer(21735, channel, null);
		prepaidServer.setLogger(logger, "prepaidServer");
		prepaidServer.addISORequestListener(new DummyIsoServer());

		// 18703 => postpaid
		ISOServer postpaidNtlServer = new ISOServer(18703, channel, null);
		postpaidNtlServer.setLogger(logger, "postpaidNtlServer");
		postpaidNtlServer.addISORequestListener(new DummyIsoServer());

		new Thread(prepaidServer).start();
		new Thread(postpaidNtlServer).start();
	}

}
