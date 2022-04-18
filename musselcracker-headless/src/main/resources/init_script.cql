CREATE KEYSPACE IF NOT EXISTS cms WITH replication = {'class':'SimpleStrategy', 'replication_factor':1};
CREATE TABLE IF NOT EXISTS cms.content(
 id UUID PRIMARY KEY,
 name text,
 description text,
 title  text,
 sub_title  text,
 create_date date,
 modify_date date,
 publish_date date,
 html text
 );