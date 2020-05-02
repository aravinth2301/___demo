import axios from "axios";

export const vappApi = axios.create({
  baseURL: "http://localhost:7000/vapp",
  headers: {
    "Content-type": "application/json"
  }
});

export const servApi = axios.create({
  // baseURL: "http://localhost:9000/service-node/api",
  baseURL: "https://localhost:8443/api",
  headers: {
    "Content-type": "application/json",
    Authorization: "Basic YWRtaW46YWRtaW4="
  }
});

export default axios;
