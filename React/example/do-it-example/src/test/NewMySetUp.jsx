import React, { Component } from 'react';
import SvgImageButton from './SvgImageButton';
import style from './NewMySetUp.scss';
import classnames from 'classnames';
DEMO_PROPS = {};

class NewMySetUp extends Component {
  constructor(props) {

  }
  render() {
    return (
        <div className="kinpeople_modify">
            <div className="profile_modify__section">
				<div className="uio_top grid1">
					<h3 className="tit"><span className="num">1:1</span> 질문 수신설정</h3>
				</div>
				<div className="switch_set">
					<div className="profile_modify__row">
						<div className="profile_modify__title">수신설정</div>
						<div className="profile_modify__description">
							<div className="switch_box">
								{/* [D] 선택시 해당 lbl에 on클래스 추가  */}
								<label className="lbl"><input type="radio" name="rd_dir2" className="inp_rd"/>허용</label>
								<label className="lbl on"><input type="radio" name="rd_dir2" className="inp_rd"/>허용안함</label>
							</div>
					    </div>
					</div>
					<div className="profile_modify__row">
						<div className="profile_modify__title"><label for="_label-text">1일 최대 수신</label></div>
						<div className="profile_modify__description">
							<div className="profile_modify__input_wrap">
								<input type="number" className="profile_modify__input" id="_label-text"/><span>개</span>
							</div>
						</div>
						<ul className="guideList__Disc">
						    <li className="item">1일 최대 수신 개수는 등급별 하루 등록가능 답변 수 이하로 설정할 수 있습니다. <a href="#" className="linkText">도움말<i className="iconArrow"></i></a></li>
						</ul>
					</div>
				</div>
            </div>
            <div className="profile_modify__section">
                <div className="uio_top grid1">
                    <h3 className="tit">알림메일 수신설정</h3>
                </div>
                <div className="switch_set">
                    <div className="profile_modify__row">
                        <div className="profile_modify__title">수신설정</div>
                        <div className="profile_modify__description">
                            <div className="switch_box">
                                {/* [D] 선택시 해당 lbl에 on클래스 추가 */}
                                <label className="lbl"><input type="radio" name="rd_dir2" className="inp_rd"/>허용</label>
                                <label className="lbl on"><input type="radio" name="rd_dir2" className="inp_rd"/>허용안함</label>
                            </div>
                        </div>
                    </div>
                    <div className="profile_modify__row __email">
                        <div className="profile_modify__title"><label for="_label-text">메일주소</label></div>
                        <div className="profile_modify__description">
                            <div className="profile_modify__info_wrap">
                                <em className="profile_modify_info">nvqa_kin123@naver.com</em>
                                <a href="#" className="btn_modify__info">메일 주소 수정</a>
                            </div>
                        </div>
                        <ul className="guideList__Disc">
                        <li className="item">답변 등록 및 채택 시 네이버 메일로 알림메일을 받아볼 수 있습니다. 이외 서비스 소식, 이벤트 안내메일을 받아보시려면, 네이버 회원정보 > 프로모션 안내메일 수신을 허용해주세요. <a href="#" className="linkText">허용여부 확인<i className="iconArrow"></i></a></li>
                        <li className="item">eXpert 서비스의 결제 및 거래 등과 관련한 메일은 메일 수신 여부와 상관없이 발송됩니다.</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div className="profile_modify__section">
                <div className="uio_top grid1">
                    <h3 className="tit">포인트로 감사 버튼 노출 설정</h3>
                </div>
                <div className="switch_set">
                    <div className="profile_modify__row">
                        <div className="profile_modify__title">노출 설정</div>
                        <div className="profile_modify__description">
                            <div className="switch_box">
                                {/* [D] 선택시 해당 lbl에 on클래스 추가 */}
                                <label className="lbl on"><input type="radio" name="rd_dir2" className="inp_rd"/>허용</label>
                                <label className="lbl"><input type="radio" name="rd_dir2" className="inp_rd"/>허용안함</label>
                            </div>
                        </div>
                        <ul className="guideList__Disc">
                        <li className="item">노출 설정을 허용하면 공개적으로 작성한 답변에 포인트로 감사 버튼이 노출되며, 답변을 본 이용자가 포인트로 감사 버튼을 통해 네이버페이 포인트를 선물할 수 있습니다.<a href="#" className="linkText">도움말<i className="iconArrow"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div className="profile_modify__section">
                <div className="uio_top grid1">
                    <h3 className="tit">포인트로 감사 이력 노출 설정</h3>
                </div>
                <div className="switch_set">
                    <div className="profile_modify__row">
                        <div className="profile_modify__title">노출 설정</div>
                        <div className="profile_modify__description">
                            <div className="switch_box">
                                {/* [D] 선택시 해당 lbl에 on클래스 추가 */}
                                <label className="lbl on"><input type="radio" name="rd_dir2" className="inp_rd"/>허용</label>
                                <label className="lbl"><input type="radio" name="rd_dir2" className="inp_rd"/>허용안함</label>
                            </div>
                        </div>
                        <ul className="guideList__Disc">
                        <li className="item">포인트로 감사를 주고받은 이력이 있는 경우, 나의 질문 또는 공개적으로 작성한 답변에 포인트로 감사를 보내거나 받은 횟수가 각각 노출됩니다.<a href="#" className="linkText">도움말<i className="iconArrow"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div className="profile_modify__alarm">
				<div className="alarm_area">
					<strong className="title">더 많은 알림은 네이버 알림 설정에서 가능합니다.</strong>
					<ul className="guideList__Disc">
						<li className="item">답변, 채택 등 지식iN 활동 알림은 <a href="#" className="linkText">지식iN 알림</a>에서 설정하세요.</li>
						<li className="item">엑스퍼트 소식, 채팅, 음성/영상 통화 수신 설정은 <a href="#" className="linkText">지식iN eXpert 알림</a>에서 설정하세요.</li>
					</ul>
				</div>
			</div>
			<div className="btn_wrap">
				<a href="#" className="btn_gray">취소</a>
				<a href="#" className="btn_green">완료</a>
			</div>
        </div>
    );
  }
}

export default NewMySetUp;
