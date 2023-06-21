import router from "../router";
import config from "./config";

export default {
  moveTemplate(number) {
    // main
    if (number === config.PAGE_NUMBER.MainFrame) {
      router.push("/");
    } else if (number === config.PAGE_NUMBER.SignIn) {
      router.push("/signin");
    } else if (number === config.PAGE_NUMBER.LogIn) {
      router.push("/logIn");
    }
  },
};
