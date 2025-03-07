package entity;

import java.util.HashMap;
import java.util.Map;

public class GioHang {
    private Map<Integer, CartItem> items;

    public GioHang() {
        this.items = new HashMap<>();
    }

    // Thêm sản phẩm vào giỏ hàng
    public void addItem(Product product, int quantity) {
        if (product == null || quantity <= 0) return;

        int productId = product.getMaVatTu();
        items.putIfAbsent(productId, new CartItem(product, 0));

        CartItem item = items.get(productId);
        item.setQuantity(item.getQuantity() + quantity);
    }

    // Xóa sản phẩm khỏi giỏ hàng
    public void removeItem(int productId) {
        items.remove(productId);
    }

    // Cập nhật số lượng sản phẩm trong giỏ hàng
    public void updateQuantity(int productId, int quantity) {
        if (items.containsKey(productId)) {
            if (quantity > 0) {
                items.get(productId).setQuantity(quantity);
            } else {
                items.remove(productId);
            }
        }
    }

    // Tính tổng tiền giỏ hàng
    public double getTotalPrice() {
        return items.values().stream()
                .mapToDouble(item -> item.getProduct().getGiaBan() * item.getQuantity())
                .sum();
    }

    // Lấy danh sách sản phẩm trong giỏ hàng
    public Map<Integer, CartItem> getItems() {
        return items;
    }

    // Lấy tổng số lượng sản phẩm trong giỏ hàng
    public int getTotalItems() {
        return items.values().stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

    // Xóa toàn bộ giỏ hàng
    public void clear() {
        items.clear();
    }
}
