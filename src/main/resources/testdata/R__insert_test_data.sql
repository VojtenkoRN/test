TRUNCATE TABLE test.foo CASCADE;
TRUNCATE TABLE test.bar CASCADE;

INSERT INTO test.foo (uuid, value)
VALUES ('bb14ba71-aadd-4e1f-8fe8-f4a5f79e5652', 'foo0'),
       ('9c252670-1474-41ba-94ec-8bb704ab5481', 'foo1');

INSERT INTO test.bar (uuid, foo_id, value)
VALUES ('b94a82a2-4256-4220-a156-fc5984a0e2ff', 'bb14ba71-aadd-4e1f-8fe8-f4a5f79e5652', 'foo0 bar0'),
       ('b1ced43c-0ca5-4f26-9f75-6da110acb096', '9c252670-1474-41ba-94ec-8bb704ab5481', 'foo1 bar1'),
       ('c2b56af7-cbc9-46b2-9fa1-fdb2beb40149', 'bb14ba71-aadd-4e1f-8fe8-f4a5f79e5652', 'foo0 bar3');