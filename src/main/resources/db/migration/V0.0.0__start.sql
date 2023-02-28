CREATE TABLE test.foo
(
    uuid  UUID PRIMARY KEY,
    value VARCHAR NOT NULL
);

ALTER TABLE test.foo
    OWNER TO test_usr;

CREATE TABLE test.bar
(
    uuid   UUID PRIMARY KEY,
    foo_id UUID REFERENCES test.foo (uuid) NOT NULL,
    value  VARCHAR                         NOT NULL
);

ALTER TABLE test.bar
    OWNER TO test_usr;