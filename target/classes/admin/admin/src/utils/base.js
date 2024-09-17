const base = {
    get() {
        return {
            url : "http://localhost:8080/shehuizhihuiyanglaojianhu/",
            name: "shehuizhihuiyanglaojianhu",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/shehuizhihuiyanglaojianhu/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "社区智慧养老监护管理平台"
        } 
    }
}
export default base
