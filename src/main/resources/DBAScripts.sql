--  *********************************************************************
--  Update Database Script
--  *********************************************************************
--  Change Log: liquibase-changeLog.xml
--  Ran at: 11/8/17 5:52 PM
--  Against: root@localhost@jdbc:mysql://localhost:3306/barcode
--  Liquibase version: 3.5.3
--  *********************************************************************

--  Create Database Lock Table
CREATE TABLE barcode.DATABASECHANGELOGLOCK (ID INT NOT NULL, LOCKED BIT(1) NOT NULL, LOCKGRANTED datetime NULL, LOCKEDBY VARCHAR(255) NULL, CONSTRAINT PK_DATABASECHANGELOGLOCK PRIMARY KEY (ID));

--  Initialize Database Lock Table
DELETE FROM barcode.DATABASECHANGELOGLOCK;

INSERT INTO barcode.DATABASECHANGELOGLOCK (ID, LOCKED) VALUES (1, 0);

--  Lock Database
UPDATE barcode.DATABASECHANGELOGLOCK SET LOCKED = 1, LOCKEDBY = 'GFITFTLAPT00962 (10.225.141.75)', LOCKGRANTED = '2017-11-08 17:52:20.214' WHERE ID = 1 AND LOCKED = 0;

--  Create Database Change Log Table
CREATE TABLE barcode.DATABASECHANGELOG (ID VARCHAR(255) NOT NULL, AUTHOR VARCHAR(255) NOT NULL, FILENAME VARCHAR(255) NOT NULL, DATEEXECUTED datetime NOT NULL, ORDEREXECUTED INT NOT NULL, EXECTYPE VARCHAR(10) NOT NULL, MD5SUM VARCHAR(35) NULL, DESCRIPTION VARCHAR(255) NULL, COMMENTS VARCHAR(255) NULL, TAG VARCHAR(255) NULL, LIQUIBASE VARCHAR(20) NULL, CONTEXTS VARCHAR(255) NULL, LABELS VARCHAR(255) NULL, DEPLOYMENT_ID VARCHAR(10) NULL);

--  Changeset liquibase-changeLog.xml::1510130367286-1::ronelle.feranil (generated)
CREATE TABLE barcode.account_identifier (id BIGINT AUTO_INCREMENT NOT NULL, datetime_created datetime(6) NULL, datetime_modified datetime(6) NULL, account_identifier BIGINT NOT NULL, client_account_identifier VARCHAR(255) NULL, extra_details LONGTEXT NULL, gcash_wallet VARCHAR(11) NULL, hashed_pin VARCHAR(255) NULL, secondary_barcode_string VARCHAR(255) NULL, status BIT(1) NULL, CONSTRAINT PK_ACCOUNT_IDENTIFIER PRIMARY KEY (id));

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-1', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 1, '7:d4d51620055a44e922d3d1068ed0d3eb', 'createTable tableName=account_identifier', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-2::ronelle.feranil (generated)
CREATE TABLE barcode.account_identifier_history (id BIGINT NOT NULL, account_identifier BIGINT NOT NULL, client_account_identifier VARCHAR(255) NULL, datetime_created datetime(6) NULL, datetime_modified datetime(6) NULL, extra_details LONGTEXT NULL, gcash_wallet VARCHAR(11) NULL, hashed_pin VARCHAR(255) NULL, status BIT(1) NULL);

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-2', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 2, '7:d9949b73039bd385fe1849c2877f7ef6', 'createTable tableName=account_identifier_history', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-3::ronelle.feranil (generated)
CREATE TABLE barcode.apilogs (id BIGINT AUTO_INCREMENT NOT NULL, api_accessed VARCHAR(255) NULL, date_time_request datetime(6) NULL, date_time_response datetime(6) NULL, request LONGTEXT NULL, response LONGTEXT NULL, source_ip VARCHAR(255) NULL, CONSTRAINT PK_APILOGS PRIMARY KEY (id));

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-3', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 3, '7:2a7acf162f746ad838522b868a7ffcac', 'createTable tableName=apilogs', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-4::ronelle.feranil (generated)
CREATE TABLE barcode.audit_trail (id BIGINT AUTO_INCREMENT NOT NULL, datetime_created datetime(6) NULL, action VARCHAR(255) NULL, description LONGTEXT NULL, module VARCHAR(255) NULL, CONSTRAINT PK_AUDIT_TRAIL PRIMARY KEY (id));

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-4', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 4, '7:7e5c639890db529b7d87d5e173c0f09d', 'createTable tableName=audit_trail', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-5::ronelle.feranil (generated)
CREATE TABLE barcode.barcode_usage_history (id BIGINT AUTO_INCREMENT NOT NULL, datetime_created datetime(6) NULL, account_identifier_id BIGINT NULL, barcode_string VARCHAR(255) NULL, otp_string BIGINT NULL, secondary_barcode_string VARCHAR(255) NULL, status BIT(1) NULL, subscriber_gcash_wallet VARCHAR(255) NULL, CONSTRAINT PK_BARCODE_USAGE_HISTORY PRIMARY KEY (id));

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-5', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 5, '7:64f0d4176697982d6337f3aa018314e6', 'createTable tableName=barcode_usage_history', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-6::ronelle.feranil (generated)
CREATE TABLE barcode.merchant (id BIGINT AUTO_INCREMENT NOT NULL, datetime_created datetime(6) NULL, datetime_modified datetime(6) NULL, email VARCHAR(255) NULL, merchant_category VARCHAR(255) NULL, merchant_gcash_wallet VARCHAR(255) NULL, merchant_id BIGINT NULL, merchant_industry VARCHAR(255) NULL, merchant_name VARCHAR(255) NULL, mobile_number_branch VARCHAR(255) NULL, mobile_number_hq VARCHAR(255) NULL, prefix VARCHAR(255) NULL, registration_date date NULL, status BIT(1) NULL, CONSTRAINT PK_MERCHANT PRIMARY KEY (id));

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-6', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 6, '7:4b374bc204fc0eeb3ecb133bcee80889', 'createTable tableName=merchant', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-7::ronelle.feranil (generated)
CREATE TABLE barcode.merchant_keys (id BIGINT AUTO_INCREMENT NOT NULL, datetime_created datetime(6) NULL, datetime_modified datetime(6) NULL, ip_address VARCHAR(255) NULL, merchant_key VARCHAR(255) NULL, status BIT(1) NULL, token VARCHAR(255) NULL, merchant_id BIGINT NOT NULL, CONSTRAINT PK_MERCHANT_KEYS PRIMARY KEY (id));

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-7', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 7, '7:a21307e27ed000b92fbec001e9e3d140', 'createTable tableName=merchant_keys', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-8::ronelle.feranil (generated)
CREATE TABLE barcode.merchant_transidvalidator (id BIGINT AUTO_INCREMENT NOT NULL, datetime_created datetime(6) NULL, merchant_id INT NULL, status BIT(1) NULL, merchant_transid VARCHAR(255) NULL, CONSTRAINT PK_MERCHANT_TRANSIDVALIDATOR PRIMARY KEY (id));

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-8', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 8, '7:37a80b666ad4939b296782833729097b', 'createTable tableName=merchant_transidvalidator', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-9::ronelle.feranil (generated)
CREATE TABLE barcode.nonce (id BIGINT AUTO_INCREMENT NOT NULL, hmac_hash VARCHAR(255) NULL, merchant_id BIGINT NULL, nonce VARCHAR(255) NULL, timestamp datetime(6) NULL, CONSTRAINT PK_NONCE PRIMARY KEY (id));

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-9', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 9, '7:6a6ec96fd389f4f7c8fb38422f4a7cfe', 'createTable tableName=nonce', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-10::ronelle.feranil (generated)
CREATE TABLE barcode.notify_history (id BIGINT AUTO_INCREMENT NOT NULL, datetime_created datetime(6) NULL, datetime_modified datetime(6) NULL, description LONGTEXT NULL, notifty_url VARCHAR(255) NULL, params LONGTEXT NULL, status BIT(1) NULL, trasaction_id BIGINT NULL, notify_id BIGINT NULL, CONSTRAINT PK_NOTIFY_HISTORY PRIMARY KEY (id));

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-10', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 10, '7:dc8feea305eafe1884fa0063fa4215e2', 'createTable tableName=notify_history', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-11::ronelle.feranil (generated)
CREATE TABLE barcode.notify_queue (id BIGINT AUTO_INCREMENT NOT NULL, datetime_created datetime(6) NULL, datetime_modified datetime(6) NULL, description LONGTEXT NULL, notify_url VARCHAR(255) NULL, transaction_id BIGINT NOT NULL, CONSTRAINT PK_NOTIFY_QUEUE PRIMARY KEY (id));

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-11', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 11, '7:edb24fc48725b1d11cf99a1241965e21', 'createTable tableName=notify_queue', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-12::ronelle.feranil (generated)
CREATE TABLE barcode.otp (id BIGINT AUTO_INCREMENT NOT NULL, datetime_created datetime(6) NULL, datetime_modified datetime(6) NULL, otp_string INT NULL, status BIT(1) NULL, account_identifier_id BIGINT NOT NULL, CONSTRAINT PK_OTP PRIMARY KEY (id));

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-12', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 12, '7:9a9693c67f321dd4064ec7af1dbcbef5', 'createTable tableName=otp', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-13::ronelle.feranil (generated)
CREATE TABLE barcode.otphistory (id BIGINT NOT NULL, account_identifier_id BIGINT NULL, datetime_created datetime(6) NULL, datetime_modified datetime(6) NULL, otp_string INT NULL, status BIT(1) NULL);

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-13', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 13, '7:5f09543c4882e1397d56d758990b161c', 'createTable tableName=otphistory', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-14::ronelle.feranil (generated)
CREATE TABLE barcode.transactions (id BIGINT AUTO_INCREMENT NOT NULL, datetime_created datetime(6) NULL, datetime_modified datetime(6) NULL, amount DECIMAL(14, 3) NULL, barcode_string VARCHAR(24) NULL, description LONGTEXT NULL, gcash_transid VARCHAR(255) NULL, merchant_gcash_wallet VARCHAR(255) NULL, merchant_id INT NULL, merchant_name VARCHAR(255) NULL, merchant_transid VARCHAR(255) NULL, notify_url VARCHAR(255) NULL, secondary_barcode_string VARCHAR(255) NULL, source_instance VARCHAR(255) NULL, status BIT(1) NULL, subscriber_gcash_wallet VARCHAR(11) NULL, transaction_type VARCHAR(255) NULL, CONSTRAINT PK_TRANSACTIONS PRIMARY KEY (id));

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-14', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 14, '7:1e2c75a729f395a6296baad8002e891b', 'createTable tableName=transactions', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-15::ronelle.feranil (generated)
ALTER TABLE barcode.account_identifier_history ADD PRIMARY KEY (id);

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-15', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 15, '7:6ef552cb89c646009d9dc986ebf78ab7', 'addPrimaryKey constraintName=PRIMARY, tableName=account_identifier_history', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-16::ronelle.feranil (generated)
ALTER TABLE barcode.otphistory ADD PRIMARY KEY (id);

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-16', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 16, '7:953965dd6790f8d58f2bc47008ed17fc', 'addPrimaryKey constraintName=PRIMARY, tableName=otphistory', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-17::ronelle.feranil (generated)
ALTER TABLE barcode.account_identifier ADD CONSTRAINT UK_ebn82gtf5wc0k6o1j8y0qgsqe UNIQUE (account_identifier);

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-17', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 17, '7:db178d6fc715e2075c38738768492d58', 'addUniqueConstraint constraintName=UK_ebn82gtf5wc0k6o1j8y0qgsqe, tableName=account_identifier', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-18::ronelle.feranil (generated)
ALTER TABLE barcode.transactions ADD CONSTRAINT UK_rmmjr77ew2ynedny3ap6fkcdj UNIQUE (merchant_transid);

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-18', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 18, '7:477f16e4dab8d2a2dcb2f81a8ca084b4', 'addUniqueConstraint constraintName=UK_rmmjr77ew2ynedny3ap6fkcdj, tableName=transactions', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-19::ronelle.feranil (generated)
CREATE INDEX FK7e8mbcang941jo2ybtq4cp5jv ON barcode.notify_history(notify_id);

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-19', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 19, '7:527e73de319e4ad33f57020bead7f286', 'createIndex indexName=FK7e8mbcang941jo2ybtq4cp5jv, tableName=notify_history', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-20::ronelle.feranil (generated)
CREATE INDEX FK97y7mac19jgjvos9uh8y4nv3c ON barcode.otp(account_identifier_id);

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-20', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 20, '7:d032137bf2d9a483dc85f29c08850504', 'createIndex indexName=FK97y7mac19jgjvos9uh8y4nv3c, tableName=otp', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-21::ronelle.feranil (generated)
CREATE INDEX FKd5b80ld3rm8dd63fwetbxmf93 ON barcode.merchant_transidvalidator(merchant_transid);

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-21', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 21, '7:2ac1d4eaaf83ed344bc8aaa4f5598e23', 'createIndex indexName=FKd5b80ld3rm8dd63fwetbxmf93, tableName=merchant_transidvalidator', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-22::ronelle.feranil (generated)
CREATE INDEX FKkc21app4bwdqxt9ouyq7da5o1 ON barcode.notify_queue(transaction_id);

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-22', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 22, '7:b6136de226765c702d98e2f52926eb3c', 'createIndex indexName=FKkc21app4bwdqxt9ouyq7da5o1, tableName=notify_queue', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-23::ronelle.feranil (generated)
CREATE INDEX FKoe2nljgj26gtmrwque3n7qs1 ON barcode.merchant_keys(merchant_id);

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-23', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 23, '7:d55f3de2fa6d2093ad56483107dc9d04', 'createIndex indexName=FKoe2nljgj26gtmrwque3n7qs1, tableName=merchant_keys', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-24::ronelle.feranil (generated)
ALTER TABLE barcode.notify_history ADD CONSTRAINT FK7e8mbcang941jo2ybtq4cp5jv FOREIGN KEY (notify_id) REFERENCES barcode.notify_queue (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-24', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 24, '7:848c2422139497a139a75abc2bec7dad', 'addForeignKeyConstraint baseTableName=notify_history, constraintName=FK7e8mbcang941jo2ybtq4cp5jv, referencedTableName=notify_queue', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-25::ronelle.feranil (generated)
ALTER TABLE barcode.otp ADD CONSTRAINT FK97y7mac19jgjvos9uh8y4nv3c FOREIGN KEY (account_identifier_id) REFERENCES barcode.account_identifier (account_identifier) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-25', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 25, '7:59a68047ec8bf861b82b11bdeee67ec7', 'addForeignKeyConstraint baseTableName=otp, constraintName=FK97y7mac19jgjvos9uh8y4nv3c, referencedTableName=account_identifier', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-26::ronelle.feranil (generated)
ALTER TABLE barcode.merchant_transidvalidator ADD CONSTRAINT FKd5b80ld3rm8dd63fwetbxmf93 FOREIGN KEY (merchant_transid) REFERENCES barcode.transactions (merchant_transid) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-26', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 26, '7:4a8b07d5b552e7850e828ece826aa274', 'addForeignKeyConstraint baseTableName=merchant_transidvalidator, constraintName=FKd5b80ld3rm8dd63fwetbxmf93, referencedTableName=transactions', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-27::ronelle.feranil (generated)
ALTER TABLE barcode.notify_queue ADD CONSTRAINT FKkc21app4bwdqxt9ouyq7da5o1 FOREIGN KEY (transaction_id) REFERENCES barcode.transactions (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-27', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 27, '7:1725724ee36eb986e9228dba03f6c93d', 'addForeignKeyConstraint baseTableName=notify_queue, constraintName=FKkc21app4bwdqxt9ouyq7da5o1, referencedTableName=transactions', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Changeset liquibase-changeLog.xml::1510130367286-28::ronelle.feranil (generated)
ALTER TABLE barcode.merchant_keys ADD CONSTRAINT FKoe2nljgj26gtmrwque3n7qs1 FOREIGN KEY (merchant_id) REFERENCES barcode.merchant (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO barcode.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1510130367286-28', 'ronelle.feranil (generated)', 'liquibase-changeLog.xml', NOW(), 28, '7:9b4d772f04aeb5ae44ed93cf40c331f9', 'addForeignKeyConstraint baseTableName=merchant_keys, constraintName=FKoe2nljgj26gtmrwque3n7qs1, referencedTableName=merchant', '', 'EXECUTED', NULL, NULL, '3.5.3', '0134741173');

--  Release Database Lock
UPDATE barcode.DATABASECHANGELOGLOCK SET LOCKED = 0, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

