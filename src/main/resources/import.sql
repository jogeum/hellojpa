INSERT INTO category (id, name) VALUES (1, 'SPRING');
INSERT INTO category (id, name) VALUES (2, 'JAVA');

INSERT INTO post (id, category_id, title, content, created_by, created_date) VALUES(1, 1, '대한민국의 경제질서는 개인과 기업의 경제상의 자유와 창의를 ...', '정당은 법률이 정하는 바에 의하여 국가의 보호를 받으며, 국가는 법률이 정하는 바에 의하여 정당운영에 필요한 자금을 보조할 수 있다. 민주평화통일자문회의의 조직·직무범위 기타 필요한 사항은 법률로 정한다.', 'jogeum', '2018-09-01 14:00:00');
INSERT INTO post (id, category_id, title, content, created_by, created_date) VALUES(2, 1, '국가안전보장회의는 대통령이 주재한다. 국가는 지역간의 균형있...', '국가는 균형있는 국민경제의 성장 및 안정과 적정한 소득의 분배를 유지하고, 시장의 지배와 경제력의 남용을 방지하며, 경제주체간의 조화를 통한 경제의 민주화를 위하여 경제에 관한 규제와 조정을 할 수 있다.', '조금', '2018-09-10 14:00:00');
INSERT INTO post (id, category_id, title, content, created_by, created_date) VALUES(3, 1, '모든 국민은 그 보호하는 자녀에게 적어도 초등교육과 법률이 정...', '국가는 평생교육을 진흥하여야 한다. 국채를 모집하거나 예산외에 국가의 부담이 될 계약을 체결하려 할 때에는 정부는 미리 국회의 의결을 얻어야 한다.', '조금', '2018-09-19 14:00:00');
INSERT INTO post (id, category_id, title, content, created_by, created_date) VALUES(4, 2, '모든 국민은 인간으로서의 존엄과 가치를 가지며, 행복을 추구할...', '국가는 재해를 예방하고 그 위험으로부터 국민을 보호하기 위하여 노력하여야 한다. 예비비는 총액으로 국회의 의결을 얻어야 한다. 예비비의 지출은 차기국회의 승인을 얻어야 한다.', 'jogeum', '2018-10-01 14:00:00');
INSERT INTO post (id, category_id, title, content, created_by, created_date) VALUES(5, 2, '국민경제자문회의의 조직·직무범위 기타 필요한 사항은 법률로 ...', '대통령은 국무회의의 의장이 되고, 국무총리는 부의장이 된다. 헌법재판소 재판관은 정당에 가입하거나 정치에 관여할 수 없다. 국회의원은 국가이익을 우선하여 양심에 따라 직무를 행한다.', 'jogeum', '2018-10-10 14:00:00');

INSERT INTO post_detail (post_id, description) VALUES (2, '모든 국민은 인간으로서의 존엄과 가치를 가지며, 행복을 추구할 권리를 가진다. 국가는 개인이 가지는 불가침의 기본적 인권을 확인하고 이를 보장할 의무를 진다....');
INSERT INTO post_detail (post_id, description) VALUES (4, '대한민국은 민주공화국이다. 법관이 중대한 심신상의 장해로 직무를 수행할 수 없을 때에는 법률이 정하는 바에 의하여 퇴직하게 할 수 있다. 모든 국민은 인간다운 생활을 할 권리를 가진다....');
INSERT INTO post_detail (post_id, description) VALUES (5, '대법원과 각급법원의 조직은 법률로 정한다. 지방자치단체는 주민의 복리에 관한 사무를 처리하고 재산을 관리하며, 법령의 범위안에서 자치에 관한 규정을 제정할 수 있다....');

INSERT INTO tag (name) VALUES('HELLO');
INSERT INTO tag (name) VALUES('JPA');
INSERT INTO tag (name) VALUES('SPRING 2.0');
INSERT INTO tag (name) VALUES('JAVA');
INSERT INTO tag (name) VALUES('H2');

INSERT INTO post_reply (post_id, reply) VALUES (1, '새로운 회계연도가 개시될 때까지 예산안이 의결되지 못한 때에는 정부는 국회에서 예산안이 의결될 때까지 다음의 목적을 위한 경비는 전년도 예산에 준하여 집행할 수 있다....');
INSERT INTO post_reply (post_id, reply) VALUES (3, '제1항의 탄핵소추는 국회재적의원 3분의 1 이상의 발의가 있어야 하며, 그 의결은 국회재적의원 과반수의 찬성이 있어야 한다. 다만, 대통령에 대한 탄핵소추는 국회재적의원 과반수의 발의와 국회재적의원 3분의 2 ...');

INSERT INTO post_tag (post_id, tag_name) VALUES (1, 'JAVA');
INSERT INTO post_tag (post_id, tag_name) VALUES (2, 'JAVA');
INSERT INTO post_tag (post_id, tag_name) VALUES (3, 'JAVA');
INSERT INTO post_tag (post_id, tag_name) VALUES (4, 'JAVA');
INSERT INTO post_tag (post_id, tag_name) VALUES (5, 'JAVA');

INSERT INTO post_tag (post_id, tag_name) VALUES (1, 'SPRING 2.0');
INSERT INTO post_tag (post_id, tag_name) VALUES (2, 'SPRING 2.0');
INSERT INTO post_tag (post_id, tag_name) VALUES (3, 'SPRING 2.0');

INSERT INTO post_tag (post_id, tag_name) VALUES (2, 'JPA');
INSERT INTO post_tag (post_id, tag_name) VALUES (4, 'JPA');

