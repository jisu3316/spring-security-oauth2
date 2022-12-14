# spring-security-oauth2
spring-security-oauth2


# OAuth
OAuth = Open + Authorization
개방형 인가, 개방형 권한 부여라는 이름을 가지고 있다.  
OAuth 2.0 인가 프레임워크는 애플리케이션이 사용자 대신하여 사용자의 자원에 대한 제한된 액세스를 얻기 위해 승인 상호 작용을 함으로써
애플리케이션이 자체적으로 액세스 권한을 얻도록 한다.  
즉 사용자가 속한 사이트의 보호된 자원(Protected Resource) 에 대하여 어플리케이션의 접근을 허용하도록 승인하는 것을 의미한다.

# OAuth 2.0 Roles 
1. Resource Owner (자원 소유자)  
• 보호된 자원에 대한 접근 권한을 부여할 수 있는 주체, 사용자로서 계정의 일부에 대한 접근 권한을 부여하는 사람  
• 사용자를 대신하여 작동하려는 모든 클라이언트는 먼저 사용자의 허가를 받아야 한다  
2. Resource Server (보호자원서버)  
• 타사 어플리케이션에서 접근하는 사용자의 자원이 포함된 서버를 의미한다  
• 액세스 토큰을 수락 및 검증할 수 있어야 하며 권한 체계에 따라 요청을 승인할 수 있어야 한다.   
3. Authorization Server (인가서버)  
• 클라이언트가 사용자 계정에 대한 동의 및 접근을 요청할 때 상호 작용하는 서버로서 클라이언트의 권한 부여 요청을 승인하거나 거부하는 서버  
• 사용자가 클라이언트에게 권한 부여 요청을 승인한 후 access token 을 클라이언트에게 부여하는 역할  
4. Client (클라이언트)  
• 사용자를 대신하여 권한을 부여받아 사용자의 리소스에 접근하려는 어플리케이션  
• 사용자를 권한 부여 서버로 안내하거나 사용자의 상호 작용 없이 권한 부여 서버로부터 직접 권한을 얻을 수 있다  

# Oauth 2.0 Client Types
## 개요  
• RFC 6749 - https://datatracker.ietf.org/doc/html/rfc6749#section-2.1  
• 인증 서버에 클라이언트를 등록할 때 클라이언트 자격 증명인 클라이언트 아이디와 클라이언트 암호를 받는다.  
• 클라이언트 암호는 비밀이고 그대로 유지되어야 하는 반면 클라이언트 아이디는 공개이다.   
• 이 자격 증명은 인증 서버에 대한 클라이언트 ID를 증명한다.  
## 기밀 클라이언트(Confidential Clients)  
• 기밀 클라이언트는 client_secret 의 기밀성을 유지할 수 있는 클라이언트를 의미한다.  
• 일반적으로 사용자가 소스 코드에 액세스할 수 없는 서버에서 실행되는 응용 프로그램으로 NET, Java, PHP 및 Node.JS와 같은 서버 측 언어로 작성된다.  
• 이러한 유형의 애플리케이션은 대부분 웹 서버에서 실행되기 때문에 일반적으로 ＂웹 앱＂이라고 한다.  
## 공개 클라이언트(Public Clients)  
• 공개 클라이언트는 client_secret 의 기밀을 유지할 수 없으므로 이러한 앱에는 secret 이 사용되지 않는다.   
• 브라우저(SPA)에서 실행되는 JavaScript 애플리케이션, Android 또는 iOS 모바일 앱, 데스크톱에서 실행되는 기본 앱뿐만 아니라 IoT/임베디드 장치에서 실행되는 애
플리케이션 등이 있다.  
• Chrome 개발자 콘솔이나 디스어셈블러와 같은 디버깅 도구를 사용하여 바이너리/실행 코드에서 기밀 정보를 추출할 수 있기 때문에 공개로 간주된다.  
• 서버측이 아닌 리소스 소유자가 사용하는 장치에서 실행되는 모든 클라이언트는 공개 클라이언트로 간주되어야 한다.  

# Oauth 2.0 Token Types 

1. Access Token  
• 클라이언트에서 사용자의 보호된 리소스에접근하기위해 사용하는 일종의 자격 증명으로서 역할을 하며 리소스 소유자가 클라이언트에게 부여한 권한 부여의 표현이다.  
• 일반적으로 JWT(JSON Web Tokens) 형식을 취하지만 사양에 따라 그럴 필요는 없다.  
• 토큰에는 해당 액세스 기간, 범위 및 서버에 필요한 기타 정보가 있다.  
• 타입에는 식별자 타입 (Identifier Type) 과 자체 포함타입 (Self-contained Type) 이 있다.  
2. Refresh Token  
• 액세스 토큰이 만료된 후 새 액세스 토큰을 얻기 위해 클라이언트응용 프로그램에서사용하는자격 증명  
• 액세스 토큰이 만료되는 경우 클라이언트는 권한 부여 서버로 인증하고 Refresh Token 을 전달한다.  
• 인증 서버는 Refresh Token 의 유효성을 검사하고 새 액세스 토큰을 발급한다.  
• Refresh Token 은 액세스 토큰과 달리 권한 서버 토큰 엔드포인트에만 보내지고 리소스 서버에는 보내지 않는다.  
3. ID Token  
• OpenID Connect 챕터에서 학습함  
4. Authorization Code  
• 권한 부여 코드 흐름에서 사용되며 이 코드는 클라이언트가액세스 토큰과 교환할 임시 코드임.  
• 사용자가 클라이언트가 요청하는 정보를 확인하고 인가 서버로부터 리다이렉트 되어 받아온다.  

# OAuth 2.0 Grant Types. 
• 권한 부여 유형.  

• 권한부여란 클라이언트가 사용자를 대신해서 사용자의 승인하에 인가서버로부터 권한을 부여받는 것을 의미한다. 
• OAuth 2.0 메커니즘은 아래와 같은 권한 부여 유형들을 지원하고 있으며 일부는 Depreacted 되었다. 
1. Authorization Code Grant Type
   권한 코드 부여 타입, 서버 사이드 어플리케이션(웹 어플리케이션), 보안에 가장 안전한 유형

2. Implicit Grant Type (Deprecated)
   암시적 부여 타입, 공개 클라이언트 어플리케이션 (SPA 기반 자바스크립트 앱, 모바일 앱), 보안에 취약

3. Resource Owner Password Credentials Grant Type (Deprecated)
   리소스 사용자 비밀번호 자격증명 부여 타입, 서버 어플리케이션, 보안에 취약

4. Client Credentials Grant Type
   클라이언트 자격 증명 권한 부여 타입 , UI or 화면이 없는 서버 어플리케이션

5. Refresh Token Grant Type
   새로고침 토큰 부여 타입, Authorization Code, Resource Owner Password Type 에서 지원

6. PKCE-enhanced Authorization Code Grant Type
   PKCE 권한 코드 부여 타입 , 서버 사이드 어플리케이션, 공개 클라이언트 어플리케이션
   
## 매개변수 용어  
1) client_id  
   인가서버에 등록된 클라이언트에 대해 생성된 고유 키  
2) client_secret  
   인가서버에 등록된 특정 클라이언트의 client_id 에 대해 생성된 비밀 값  
3) response_type  
   애플리케이션이 권한 부여 코드 흐름을 시작하고 있음을 인증 서버에 알려준다  
   code, token, id_token 이 있으며 token, id_token 은 implicit 권한부여유형에서 지원해야 한다  
   서버가 쿼리 문자열에 인증 코드(code), 토큰(token, id_token) 등을 반환  
4) grant_type  
   권한 부여 타입 지정 - authorization_code, password, client_credentials, refresh_token  
5) redirect_uri  
   사용자가 응용 프로그램을 성공적으로 승인하면 권한 부여 서버가 사용자를 다시 응용 프로그램으로 리디렉션한다  
   redirect_uri 가 초기 권한 부여 요청에 포함된 경우 서비스는 토큰 요청에서도 이를 요구해야 한다.   
   토큰 요청의 redirect_uri 는 인증 코드를 생성할 때 사용된 redirect_uri 와 정확히 일치해야 한다. 그렇지 않으면 서비스는 요청을 거부해야 한다.  
6) scope  
   어플리케이션이 사용자 데이터에 접근하는 것을 제한하기 위해 사용된다 – email profile read write..  
   사용자에 의해 특정 스코프로 제한된 권한 인가권을 발행함으로써 데이터 접근을 제한한다  
7) state  
   응용 프로그램은 임의의 문자열을 생성하고 요청에 포함하고 사용자가 앱을 승인한 후 서버로부터 동일한 값이 반환되는지 확인해야 한다.   
   이것은 CSRF 공격 을 방지하는 데 사용된다  
