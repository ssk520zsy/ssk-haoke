import request from "../common/request";

export async function fakeAccountLogin(params) {
  return request("/api/login/account", {
    method: "POST",
    data: params
  });
}

export async function fakeRegister(params) {
  return request("/api/register", {
    method: "POST",
    data: params
  });
}

export async function getFakeCaptcha(mobile) {
  return request(`/api/captcha?mobile=${mobile}`);
}
