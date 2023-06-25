export default {
  PAGE_NUMBER: {
    MainFrame: 1,
    SignIn: 2,
    LogIn: 3,
  },
  LoginType: {
    IdType: "1",
    EmailType: "2",
  },
  Url: {
    buyer: {
      default: "v1/user/buyer",
      signIn: "/signIn",
      logIn: "/logIn",
    },
    map: {
      default: "v1/map/yahoo",
      localSearch: "/localSearch",
    },
  },
  RES_STATE: {
    OK: 0,
    NG: 1,
  },
  SELECT_SEARCH: {
    creditcard: "creditcard",
    parking: "parking",
    smoking: "smoking",
  },
};
