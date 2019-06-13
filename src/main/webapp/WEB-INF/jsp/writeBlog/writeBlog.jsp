<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
    <head>
        <meta charset="utf-8" />
        <title>Simple example - Editor.md examples</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/static/markdown/examples/css/style.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath }/static/markdown/css/editormd.css" />
        <link rel="Shortcut Icon" href="${pageContext.request.contextPath }/static/images/title.jpg" type="image/x-icon">
    </head>
    <body>
        <div id="layout">
            <header>
                <h1>Simple example</h1>
            </header>
            <div id="test-editormd">
                <textarea style="display:none;">
				</textarea>
            </div>
        </div>
        <script src="${pageContext.request.contextPath }/static/markdown/examples/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath }/static/markdown/editormd.js"></script>
        <script type="text/javascript">
			var testEditor;
			var path = '${pageContext.request.contextPath}';

            $(function() {
                testEditor = editormd("test-editormd", {
                    width   : "90%",
                    height  : 640,
                    syncScrolling : "single",
                    path    : path+"/static/markdown/lib/"
                });
                
                /*
                // or
                testEditor = editormd({
                    id      : "test-editormd",
                    width   : "90%",
                    height  : 640,
                    path    : "../lib/"
                });
                */
            });
        </script>
    </body>
</html>