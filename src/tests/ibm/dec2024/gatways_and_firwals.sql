-- u have gatways with ids and has firewal ref
-- also u have firewals with no of rules
-- print gatways id along with tot ruls for firewalls for gatways with more than 1 firewall




























SELECT
    gatway.id as id,
    sum(no_of_rules) as tot_rules_no
FROM
    gatways gatway
LEFT JOIN
    firewals firewal
ON
    gatway.firewal_id = firewal.id
GROUP BY
    gatway.id
HAVING
    sum(no_of_rules) > 100 && count(gatway.firewal) > 1


























SELECT
    g.gateway_id,
    SUM(f.rule_count) AS total_rules
FROM
    gateways g
        JOIN
    firewalls f ON g.firewalls_id = f.id
GROUP BY
    g.gateway_id
HAVING
    COUNT(g.gateway_id) > 1 --U can't use the total_rules in the select in the aggregation(aggregation happens before the select)
   AND SUM(f.rule_count) >= 100;