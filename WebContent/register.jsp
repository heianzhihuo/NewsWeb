<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="utf-8">
<head>
<title>注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description"
	content="Expand, contract, animate forms with jQuery wihtout leaving the page" />
<meta name="keywords"
	content="expand, form, css3, jquery, animate, width, height, adapt, unobtrusive javascript" />
<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/style1.css" />
<script src="js/cufon-yui.js" type="text/javascript"></script>
<script src="js/ChunkFive_400.font.js" type="text/javascript"></script>
<script type="text/javascript">
	Cufon.replace('h1', {
		textShadow : '1px 1px #fff'
	});
	Cufon.replace('h2', {
		textShadow : '1px 1px #fff'
	});
	Cufon.replace('h3', {
		textShadow : '1px 1px #000'
	});
	Cufon.replace('.back');
</script>
</head>
<body>
	<div class="wrapper">
		<div class="content">
			<div id="form_wrapper" class="form_wrapper">
				<h3>Register</h3>
				<s:form class="register active" action="Register" method="post"
					theme="simple">
					<div class="column">
						<div>
							<label>用户名：</label>
							<s:textfield name="username"  required="true"/>
						</div>
						<div>
							<label>邮箱:</label>
							<s:textfield name="email" required="true"/>
						</div>
						<div>
							<label>密码：</label>
							<s:password name="password" size="22" type="password" required="true"/>
						</div>
					</div>
					<div class="bottom">
						<s:submit value="确定" type="button" />
						<s:reset value="重写" type="button" />
					</div>
				</s:form>
				<s:if test="hasFieldErrors()">
					<hr />
					<div align="center" style="color: red">
						<s:fielderror />
					</div>
				</s:if>
			</div>
			<div class="clear"></div>
		</div>
	</div>


	<!-- The JavaScript -->
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
	<script type="text/javascript">
		$(function() {
			//the form wrapper (includes all forms)
			var $form_wrapper = $('#form_wrapper'),
			//the current form is the one with class active
			$currentForm = $form_wrapper.children('form.active'),
			//the change form links
			$linkform = $form_wrapper.find('.linkform');

			//get width and height of each form and store them for later
			$form_wrapper.children('form').each(function(i) {
				var $theForm = $(this);
				//solve the inline display none problem when using fadeIn fadeOut
				if (!$theForm.hasClass('active'))
					$theForm.hide();
				$theForm.data({
					width : $theForm.width(),
					height : $theForm.height()
				});
			});

			//set width and height of wrapper (same of current form)
			setWrapperWidth();

			/*
			 clicking a link (change form event) in the form
			 makes the current form hide.
			 The wrapper animates its width and height to the
			 width and height of the new current form.
			 After the animation, the new form is shown
			 */
			$linkform.bind('click', function(e) {
				var $link = $(this);
				var target = $link.attr('rel');
				$currentForm.fadeOut(400, function() {
					//remove class active from current form
					$currentForm.removeClass('active');
					//new current form
					$currentForm = $form_wrapper.children('form.' + target);
					//animate the wrapper
					$form_wrapper.stop().animate({
						width : $currentForm.data('width') + 'px',
						height : $currentForm.data('height') + 'px'
					}, 500, function() {
						//new form gets class active
						$currentForm.addClass('active');
						//show the new form
						$currentForm.fadeIn(400);
					});
				});
				e.preventDefault();
			});

			function setWrapperWidth() {
				$form_wrapper.css({
					width : $currentForm.data('width') + 'px',
					height : $currentForm.data('height') + 'px'
				});
			}

			/*
			 for the demo we disabled the submit buttons
			 if you submit the form, you need to check the
			 which form was submited, and give the class active
			 to the form you want to show
			 */
			$form_wrapper.find('input[type="submit"]').click(function(e) {
				e.preventDefault();
			});
		});
	</script>
</body>
</html>