# WAI-ARIA

WAI-ARIA는 스크린더및 보조기기 등에서 접근성 및 상호 운용성을 향상시키기 위한 목적으로 탄생. Role,Properties,State 정보를 추가하여 이를 개선 할 수 있도록 제공하고 있다.
WAI-ARIA는 개발자의 의도가 보조 기술에 잘 전달될 수 있도록 요소(Element)나 컴포넌트에 누락된 의미 구조를 제공하는 것을 목적으로 한다.

<table>
<tr>
<th>State</th>
<th>Description</th>
<th>Used In Roles</th>
</tr>
<tr>
<td>aria-hidden</td>
<td>요소에 초점이 이동하지 않게 한다.</td>
<td>all</td>
</tr>
<tr>
<td>aria-checked</td>
<td>요소의 체크유무 상태를 나타낸다</td>
<td>option,radio,chekbox...</td>
</tr>
<tr>
<td>aria-expanded</td>
<td>요소의 확장/축소 상태를 나타낸다.</td>
<td>button,combobox ...</td>
</tr>
<tr>
<td>aria-pressed</td>
<td>요소의 on/off 상태를 나타낸다.</td>
<td>button</td>
</tr>
<tr>
<td>aria-selected</td>
<td>요소의 선택유무 상태를 나타낸다.</td>
<td>option,tab...</td>
</tr>
</table>

## 스펙
https://www.w3.org/TR/wai-aria-1.1/#states_and_properties
<br>
상태값은 true/false , token 형태도 제공.

