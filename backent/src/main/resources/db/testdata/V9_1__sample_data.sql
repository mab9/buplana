-- 1. User
INSERT INTO users (name, create_date, user_id)
VALUES
    ('mab', CURRENT_TIMESTAMP, 1),
    ('Najra', CURRENT_TIMESTAMP, 2);

-- 2. Globale Tags (FIXED, VARIABLE)
INSERT INTO tag (name, tag_type, user_id, tag_id)
VALUES
    ('FIXED', 'FIXED', null, 1),
    ('VARIABLE', 'VARIABLE', null, 2);


-- 3. Benutzerdefinierte Tags (CUSTOM)
INSERT INTO tag (name, tag_type, user_id, tag_id)
VALUES
    ('Miete', 'CUSTOM', 1, 3),
    ('Versicherung', 'CUSTOM', 1, 4),
    ('Essen', 'CUSTOM', 1, 5),
    ('Freizeit', 'CUSTOM', 1, 6),
    ('Rennrad', 'CUSTOM', 1, 7),
    ('Hundeausgaben', 'CUSTOM', 1, 8);

-- 4. Budgets pro User
INSERT INTO budget (name, user_id, budget_id)
VALUES
    ('Haushalt 2025', 1, 1),
    ('Sommerurlaub', 1, 2),
    ('Privat', 2, 3);

-- 5. Expenses
INSERT INTO expense (amount, note, frequency, budget_id, tag_id, date)
VALUES
    (1500.00, 'Miete', 'MONTHLY', 1, 1, '2025-01-01'),
    (250.00, 'Lebensmittel KW1', 'WEEKLY', 1, 3, '2025-01-07'),
    (120.00, 'Rennrad Ersatzteile', 'YEARLY', 1, 5, '2025-06-15'),
    (50.00, 'Hundespielzeug', 'MONTHLY', 1, 6, '2025-03-01');
