/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.modelo.Vendedor;

/**
 *
 * @author jeffa
 */
public interface VendedorDAO {
      public List<Vendedor> select();
    public void insert (Vendedor vendedor);
    public void update (Vendedor vendedor);
    public void delete (Vendedor vendedor);
}
