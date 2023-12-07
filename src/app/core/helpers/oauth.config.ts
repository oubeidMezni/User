// oauth.config.ts
import { AuthConfig } from 'angular-oauth2-oidc';

export const authConfig: AuthConfig = {
  issuer: 'accounts.google.com',
  redirectUri: window.location.origin + '/login',
  clientId: '1010141049601-a1rl7fug11qk5p5cq1cqme3j8p6fhdop.apps.googleusercontent.com',
  scope: 'openid profile email',
  showDebugInformation: true,
};
