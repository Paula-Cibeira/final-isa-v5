// este test realiza un login utilizando la API y guarda el token en localStorage - funciono
describe('Login via API', () => {
  it('should login successfully via API', () => {
    cy.request({
      method: 'POST',
      url: '/api/authenticate',
      body: {
        username: 'admin',
        password: 'admin',
        rememberMe: true,
      },
    }).then(response => {
      expect(response.status).to.eq(200);
      window.localStorage.setItem('jhi-authenticationToken', response.body.id_token);
    });
  });
});
