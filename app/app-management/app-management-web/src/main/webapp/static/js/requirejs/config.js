//JS路径配置
requirejs.config({
	baseUrl : path+'/static/js/requirejs/',
	paths : {
		jquery : '../jquery/jquery-3.1.0.min',
		bootstrap : '../../dist/js/bootstrap.min',
		utils : '../common/utils'
	},
	 shim : {
		'bootstrap' : [ 'jquery' ],
		'utils' : [ 'jquery' ]
	}
});