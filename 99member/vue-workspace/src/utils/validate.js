// 共通入力内容検証用JS

// 必須入力項目
export function validateNecessary(str) {
  return {
    required: true,
    message: str + "を入力してください",
    trigger: ["blur", "change"],
  }
}

// 必須選択項目
export function validateSelect(str) {
  return {
    required: true,
    message: str + "をお選びください",
    trigger: ["blur", "change"],
  }
}

// 最大長
export function validateLen(len) {
  return {
    max: len,
    message: '最大長は' + len + '文字です',
    trigger: 'blur'
  }
}

// 小文字の英字
export function validateLowerCase(str) {
  const reg = /^[a-z]+$/;
  return reg.test(str);
}

// 大文字の英字
export function validateUpperCase(str) {
  const reg = /^[A-Z]+$/;
  return reg.test(str);
}

// 英字
export function validateAlphabets(str) {
  const reg = /^[A-Za-z]+$/;
  return reg.test(str);
}

// 数字
export function validateNum(str) {
  const reg = /^[0-9]+$/;
  return reg.test(str);
}

// メールアドレス
export function validateEmail(rule, value, callback) {
  const reg = /^([a-zA-Z0-9]+[-_.]?)+@[a-zA-Z0-9]+\.[a-z]+$/;
  if (value == '' || value == undefined || value == null) {
    callback();
  } else {
    if (!reg.test(value)) {
      callback(new Error('正確なメールアドレスを入力してください'));
    } else {
      callback();
    }
  }
}

// パスワード
export function isPassword(rule, value, callback) {
  const reg = /^[_a-zA-Z0-9]+$/;
  if (value == '' || value == undefined || value == null) {
    callback();
  } else {
    if (!reg.test(value)) {
      callback(new Error('英字と数字または_を入力してください'));
    } else {
      callback();
    }
  }
}
// 数字処理 マウスの焦点が失う場合
export function numOnBlur(num, endBy) {
  if (num.target.value === "") {
    return;
  } else {
    var val = num.target.value;
    var int = val
      .split("")
      .reverse()
      .join("");
    var temp = "";
    for (var i = 0; i < int.length; i++) {
      temp += int[i];
      if ((i + 1) % 3 == 0 && i != int.length - 1) {
        temp += ",";
      }
    }
    temp = temp
      .split("")
      .reverse()
      .join("");
    num.target.value = temp + endBy;
  }
}
// 数字処理 マウスの焦点が獲得する場合
export function numOnFocus(num) {
  if (num.target.value === "") {
    return;
  } else {
    var val = num.target.value;
    val = val.replace(/,/g, "");
    var temp = val.substr(0, val.length - 1);
    num.target.value = temp;
  }
}
// 金額処理 マウスの焦点が獲得する場合
export function moneyOnFocus(num) {
  if (num.target.value === "") {
    return;
  } else {
    var val = num.target.value;
    val = val.replace(/,/g, "");
    var temp = val.substr(0, val.length);
    num.target.value = temp;
  }
}
// 電話番号処理 マウスの焦点が獲得する場合
export function telOnFocus(num) {
  if (num.target.value === "") {
    return;
  } else {
    var val = num.target.value;
    val = val.replace(/-/g, "");
    var temp = val.substr(0, val.length);
    num.target.value = temp;
  }
}
// 電話番号処理 データが表示する場合
export function telOnInfo(val) {
  if (val === "" && val.length != 11) {
    return;
  } else {
    var int = val
      .split("")
      .reverse()
      .join("");
    var temp = "";
    for (var i = 0; i < int.length; i++) {
      temp += int[i];
      if ((i + 1) % 4 == 0 && i != int.length - 1) {
        temp += "-";
      }
    }
    temp = temp
      .split("")
      .reverse()
      .join("");
    val = temp;
    return val;
  }
}
// 電話番号処理 マウスの焦点が失う場合
export function telOnBlur(num) {
  if (num.target.value === "" && num.length != 11) {
    return;
  } else {
    var val = num.target.value;
    var int = val
      .split("")
      .reverse()
      .join("");
    var temp = "";
    for (var i = 0; i < int.length; i++) {
      temp += int[i];
      if ((i + 1) % 4 == 0 && i != int.length - 1) {
        temp += "-";
      }
    }
    temp = temp
      .split("")
      .reverse()
      .join("");
    num.target.value = temp;
  }
}
//  全角を半角に変換
export function toCDB(str) {
  var tmp = "";
  for (var i = 0; i < str.length; i++) {
    if (str.charCodeAt(i) == 12288) {
      tmp += String.fromCharCode(str.charCodeAt(i) - 12256);
      continue;
    }
    if (str.charCodeAt(i) > 65280 && str.charCodeAt(i) < 65375) {
      tmp += String.fromCharCode(str.charCodeAt(i) - 65248);
    } else {
      tmp += String.fromCharCode(str.charCodeAt(i));
    }
  }
  return tmp;
}

//  半角を全角に変換
export function toDBC(str) {
  var tmp = "";
  for (var i = 0; i < str.length; i++) {
    if (str.charCodeAt(i) == 32) {
      tmp = tmp + String.fromCharCode(12288);
    }
    if (str.charCodeAt(i) < 127) {
      tmp = tmp + String.fromCharCode(str.charCodeAt(i) + 65248);
    }
  }
  return tmp;
}

// アップロードファイルタイプの判断
export function matchFileSuffixType(fileName) {
  // ファイルタイプを取得
  var suffix = ''
  // タイプの取得結果
  var result = ''
  try {
    var fileArr = fileName.split('.')
    suffix = fileArr[fileArr.length - 1]
  } catch (err) {
    suffix = ''
  }
  // fileName无后缀返回 false
  if (!suffix) {
    result = false
    return result
  }
  // イメージタイプ
  var imgList = ['png', 'jpg', 'jpeg', 'bmp', 'gif']
  result = imgList.some(function (item) {
    return item == suffix
  })
  if (result) {
    result = 'image'
    return result
  }
  // pdf
  var pdfList = ['pdf']
  result = pdfList.some(function (item) {
    return item == suffix
  })
  if (result) {
    result = 'pdf'
    return result
  }
  // excel
  var excelList = ['xls', 'xlsx']
  result = excelList.some(function (item) {
    return item == suffix
  })
  if (result) {
    result = 'excel'
    return result
  }
  // word
  var wordList = ['doc', 'docx']
  result = wordList.some(function (item) {
    return item == suffix
  })
  if (result) {
    result = 'word'
    return result
  }
  // power point
  var pptList = ['ppt']
  result = pptList.some(function (item) {
    return item == suffix
  })
  if (result) {
    result = 'ppt'
    return result
  }
  // text
  var txtList = ['txt']
  result = txtList.some(function (item) {
    return item == suffix
  })
  if (result) {
    result = 'txt'
    return result
  }
  // video
  var videoList = ['mp4', 'm2v', 'mkv']
  result = videoList.some(function (item) {
    return item == suffix
  })
  if (result) {
    result = 'video'
    return result
  }
  // music
  var radioList = ['mp3', 'wav', 'wmv']
  result = radioList.some(function (item) {
    return item == suffix
  })
  if (result) {
    result = 'radio'
    return result
  }
  // その他ファイル
  result = 'other'
  return result
}