ALTER TABLE if exists public.subject
ALTER COLUMN marks_obtained TYPE bigint USING marks_obtained::bigint