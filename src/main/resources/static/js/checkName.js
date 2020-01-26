$(function () {
    $('[name="shinjinId"]').change(function () {
        checkedLimitS();
        let vals = $('input[name=shinjinId]:checked').map(function () {
            return $(this).parent('label').text()
        }).get();
        $.each(vals, function (index, value) {
            switch (index) {
                case 0:
                    $('#shinjinName1').text(value+"さんへのコメント");
                    break;
                case 1:
                    $('#shinjinName2').text(value+"さんへのコメント");
                    break;
            }
        });
    });

    $('[name="ninenmeId"]').change(function () {
        checkedLimitN();
        let vals = $('input[name=ninenmeId]:checked').map(function () {
            return $(this).parent('label').text()
        }).get();
        $.each(vals, function (index, value) {
            switch (index) {
                case 0:
                    $('#ninenmeName1').text(value+"さんへのコメント");
                    break;
                case 1:
                    $('#ninenmeName2').text(value+"さんへのコメント");
                    break;
            }
        });
    });

    function checkedLimitS() {
        $('[name="shinjinId"]').prop('disabled', false);
        $('#shinjinName1').text("コメント");
        $('#shinjinName2').text("コメント");
        var len = $('[name="shinjinId"]:checked').length;

        //2つ目のチェックが入ったら、残りのチェックボックスを触れなくする
        if (len >= 2) {
            $('[name="shinjinId"]').not(':checked').prop('disabled', true);
        }
    }

    function checkedLimitN() {
        $('[name="ninenmeId"]').prop('disabled', false);
        $('#ninenmeName1').text("コメント");
        $('#ninenmeName2').text("コメント");
        var len = $('[name="ninenmeId"]:checked').length;
        //2つ目のチェックが入ったら、残りのチェックボックスを触れなくする
        if (len >= 2) {
            $('[name="ninenmeId"]').not(':checked').prop('disabled', true);
        }
    }
});