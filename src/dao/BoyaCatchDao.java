package dao;

import java.util.List;

import bean.boyacatch;

/**
 * BoyaCatchBeanのデータアクセス操作を定義するインターフェース
 */
public interface BoyaCatchDao {

    /**
     * 新しいぼやキャッチデータをデータベースに保存します (INSERT)
     * @param entry 保存するデータを持つBoyaCatchオブジェクト
     * @return 成功した場合はtrue、失敗した場合はfalse
     */
    boolean insert(boyacatch entry);

    /**
     * 特定の利用者番号と日付に一致するデータを取得します (SELECT)
     * テーブル定義より、利用者番号と日付の複合キーを検索条件とします。
     * @param userId 利用者番号
     * @param date 日付
     * @return 一致したBoyaCatchオブジェクト、見つからない場合はnull
     */
    boyacatch findByCompositeKey(int userId, java.sql.Date date);

    /**
     * 特定の利用者番号のすべてのぼやキャッチデータを取得します (SELECT)
     * @param userId 利用者番号
     * @return BoyaCatchオブジェクトのリスト
     */
    List<boyacatch> findByUserId(int userId);

    /**
     * 既存のぼやキャッチデータを更新します (UPDATE)
     * @param entry 更新データを持つBoyaCatchオブジェクト (キー情報を含む)
     * @return 成功した場合はtrue、失敗した場合はfalse
     */
    boolean update(boyacatch entry);

    /**
     * 特定のぼやキャッチデータを削除します (DELETE)
     * @param userId 利用者番号
     * @param date 日付
     * @return 成功した場合はtrue、失敗した場合はfalse
     */
    boolean delete(int userId, java.sql.Date date);
}