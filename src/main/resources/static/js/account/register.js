//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
function findAddress() {
  new daum.Postcode({
    oncomplete: function (data) {
      // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

      // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
      // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
      let address = data.address; // 도로명 주소 변수
      let extraAddress = ''; // 참고 항목 변수

      if (data.userSelectedtype === 'R') { // 사용자가 도로명 주소 선택
        address = data.readAddress;
      } else { // 사용자가 지번 주소 선택
        address = data.jibunAddress;
      }

      if(data.userSelectedtype === 'R') {
        if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
          extraAddress += data.bname;
        }
        if(data.buildingName !== '' && data.apartment === 'Y') {
          extraAddress += (extraAddress !== '' ? ', ' + data.buildingName : data.buildingName);
        }
        if(extraAddress !== '') {
          extraAddress = ' (' + extraAddress + ')';
        }
        document.getElementById('detailAddress').value = extraAddress;
      }
      document.getElementById('postcode').value = data.zonecode;
      document.getElementById('address').value = address;
      document.getElementById('detailAddress').focus();
    }
  }).open();
}