import http from 'k6/http';
import { check, sleep } from 'k6';

// smoke testing option

export const options = {
  vus: 2,           // virtual users
  duration: '1m',   // testing time
};

/* stress testing option

 export const options = {
  stages: [
    { duration: '20m', target: 250 },
    { duration: '30m', target: 250 },
    { duration: '10m', target: 0 },
  ],
};

*/

/* spike testing option

 export const options = {
  stages: [
    { duration: '3m', target: 5000 },
    // No plateau
    { duration: '2m', target: 0 },
  ],
};

*/

// set base url

const BASE_URL = 'https://reqres.in';

export default function () {

    // set payload input email and password

    const payload = JSON.stringify({
        email: 'eve.holt@reqres.in',
        password: 'cityslicka',
    });

    // set params

    const params = {
        headers: {
            'Content-Type': 'application/json',
            'x-api-key': 'free_user_3FiOt8szLd5y38S9ORg0JYVhcpn',
        },
    };

    // script check API responses

    const res = http.post(`${BASE_URL}/api/login`, payload, params);

    check(res, {
        'Response status is 200': (r) => r.status === 200,
        'Response contains valid token': (r) => r.json().token !== undefined,
    });

    sleep(1);
}