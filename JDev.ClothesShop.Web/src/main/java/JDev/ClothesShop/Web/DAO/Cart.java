/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.Web.DAO;

import JDev.ClothesShop.DAO.SanPham;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeremy
 */
public class Cart {

    private List<SanPham> list = new ArrayList<SanPham>();
    private List<Integer> listStock = new ArrayList<Integer>();

    public List<SanPham> getList() {
        return list;
    }

    public void setList(List<SanPham> list) {
        this.list = list;
    }

    public List<Integer> getListStock() {
        return listStock;
    }

    public void setListStock(List<Integer> list_stock) {
        this.listStock = list_stock;
    }

    public void Add(SanPham sanPham, int stock) {

        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (sanPham.getMaSanPham() == list.get(i).getMaSanPham()) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            list.add(sanPham);
            listStock.add(stock);
        } else {
            stock += listStock.get(index);
            listStock.add(index, stock);
        }
    }

    public int count() {
        return list.size();
    }

    public void delete(SanPham sanPham) {
        int size = list.size();

        for (int i = 0; i < size; i++) {
            if (list.get(i).getMaSanPham() == sanPham.getMaSanPham()) {
                list.remove(i);
                listStock.remove(i);
                return;
            }
        }
    }

    public void UpdateStock(int productID, int stock) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (productID == list.get(i).getMaSanPham()) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            listStock.add(index, stock);
        }
    }

    public void delete(int index) {
        list.remove(index);
        listStock.remove(index);
    }

    public int getStock(int index) {
        return listStock.get(index);
    }

    public SanPham getProduct(int index) {
        return list.get(index);
    }
}
