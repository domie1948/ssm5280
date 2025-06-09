
var projectName = '多人命题系统';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.jsp'
}, 
{
	name: '我的发布',
	url: '../forum/list-my.jsp'
},

]


var indexNav = [

{
	name: '学校公告',
	url: './pages/xuexiaogonggao/list.jsp'
}, 
{
	name: '试题信息',
	url: './pages/shitixinxi/list.jsp'
}, 

{
	name: '论坛信息',
	url: './pages/forum/list.jsp'
}, 
]

var adminurl =  "http://localhost:8080/jspm6011w/index.jsp";

var cartFlag = false

var chatFlag = false




var menu = [{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"学生","menuJump":"列表","tableName":"xuesheng"}],"menu":"学生管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"教师","menuJump":"列表","tableName":"jiaoshi"}],"menu":"教师管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"学校公告","menuJump":"列表","tableName":"xuexiaogonggao"}],"menu":"学校公告管理"},{"child":[{"buttons":["新增","查看","修改","删除","审核"],"menu":"命题信息","menuJump":"列表","tableName":"mingtixinxi"}],"menu":"命题信息管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"聊天信息","menuJump":"列表","tableName":"liaotianxinxi"}],"menu":"聊天信息管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"试题信息","menuJump":"列表","tableName":"shitixinxi"}],"menu":"试题信息管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"试卷提交","menuJump":"列表","tableName":"shijuantijiao"}],"menu":"试卷提交管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"试卷批改","menuJump":"列表","tableName":"shijuanpigai"}],"menu":"试卷批改管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"错题信息","menuJump":"列表","tableName":"cuotixinxi"}],"menu":"错题信息管理"},{"child":[{"buttons":["查看","删除","修改"],"menu":"论坛管理","tableName":"luntanguanli"}],"menu":"论坛管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"lunbotuguanli"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"学校公告列表","menuJump":"列表","tableName":"xuexiaogonggao"}],"menu":"学校公告模块"},{"child":[{"buttons":["查看","提交试卷"],"menu":"试题信息列表","menuJump":"列表","tableName":"shitixinxi"}],"menu":"试题信息模块"}],"roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"buttons":["查看"],"menu":"试卷提交","menuJump":"列表","tableName":"shijuantijiao"}],"menu":"试卷提交管理"},{"child":[{"buttons":["查看"],"menu":"试卷批改","menuJump":"列表","tableName":"shijuanpigai"}],"menu":"试卷批改管理"},{"child":[{"buttons":["查看"],"menu":"错题信息","menuJump":"列表","tableName":"cuotixinxi"}],"menu":"错题信息管理"},{"child":[{"buttons":["查看","删除"],"menu":"论坛管理","tableName":"luntanguanli"}],"menu":"论坛管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"学校公告列表","menuJump":"列表","tableName":"xuexiaogonggao"}],"menu":"学校公告模块"},{"child":[{"buttons":["查看","提交试卷"],"menu":"试题信息列表","menuJump":"列表","tableName":"shitixinxi"}],"menu":"试题信息模块"}],"roleName":"学生","tableName":"xuesheng"},{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"命题信息","menuJump":"列表","tableName":"mingtixinxi"}],"menu":"命题信息管理"},{"child":[{"buttons":["新增","查看","回复"],"menu":"聊天信息","menuJump":"列表","tableName":"liaotianxinxi"}],"menu":"聊天信息管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"试题信息","menuJump":"列表","tableName":"shitixinxi"}],"menu":"试题信息管理"},{"child":[{"buttons":["查看","批改"],"menu":"试卷提交","menuJump":"列表","tableName":"shijuantijiao"}],"menu":"试卷提交管理"},{"child":[{"buttons":["查看","删除"],"menu":"试卷批改","menuJump":"列表","tableName":"shijuanpigai"}],"menu":"试卷批改管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"错题信息","menuJump":"列表","tableName":"cuotixinxi"}],"menu":"错题信息管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"学校公告列表","menuJump":"列表","tableName":"xuexiaogonggao"}],"menu":"学校公告模块"},{"child":[{"buttons":["查看","提交试卷"],"menu":"试题信息列表","menuJump":"列表","tableName":"shitixinxi"}],"menu":"试题信息模块"}],"roleName":"教师","tableName":"jiaoshi"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
