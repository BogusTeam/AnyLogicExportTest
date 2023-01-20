create table public.data
(
    id serial PRIMARY KEY,
    sim_year integer,
    scenario_number integer,
    cust_refused bigint,
    cust_served bigint,
    terminals integer
);
