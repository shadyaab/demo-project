CREATE TABLE topic(
	topic_id IDENTITY,
	topic_title VARCHAR(255),
	topic_desc CLOB,
	is_active BOOLEAN,
	CONSTRAINT pk_topic_id PRIMARY KEY (topic_id)
)