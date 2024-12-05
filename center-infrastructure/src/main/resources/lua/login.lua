local userId = KEYS[1];
local token = ARGV[1];
local info = ARGV[2];
local time = ARGV[3];

redis.call('hmset', userId, 'token', token, 'info', info);
redis.call('expire', userId, time);

return 1;