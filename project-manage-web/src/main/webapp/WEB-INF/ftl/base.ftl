<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${model.title}</title>
<#list model.cssFiles as cssFile>
    <link rel="stylesheet" href="${cssFile}"/>
</#list>
    <script >
       var _global =${model.global};
    </script>
</head>
<body>

<div id="root"></div>
<#list model.jsFiles as jsFile>
<script src="${jsFile}"></script>
</#list>

</body>
</html>