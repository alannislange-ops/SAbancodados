CREATE TRIGGER senha_apos_login BEFORE INSERT ON LOGIN 
FOR EACH ROW BEGIN
    SET NEW.senha_login = SHA2(NEW.senha_login, 256);
END;

CREATE TRIGGER senha_apos_update BEFORE UPDATE ON LOGIN 
FOR EACH ROW BEGIN
    SET NEW.senha_login = SHA2(NEW.senha_login, 256);
END;
