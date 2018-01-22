--liquibase formatted sql
--changeset default:init_db_schema

CREATE SCHEMA IF NOT EXISTS my_schema;

--rollback DROP SCHEMA spring_data_test.my_schema CASCADE;

--changeset default:create_first_table

CREATE TABLE my_schema.first_table (
  ft_id SERIAL8 ,
  ft_name VARCHAR(32) UNIQUE NOT NULL ,
  ft_description text NOT NULL ,
  ft_created_at TIMESTAMP DEFAULT now() ,
  ft_updated_at TIMESTAMP DEFAULT now() ,
  CONSTRAINT ft_id_primary_key PRIMARY KEY (ft_id) ,
  CONSTRAINT ft_name_key UNIQUE (ft_name)
)

--rollback DROP TABLE my_schema.first_table CASCADE;
