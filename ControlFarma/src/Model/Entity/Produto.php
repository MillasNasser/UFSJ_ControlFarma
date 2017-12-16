<?php
namespace App\Model\Entity;

use Cake\ORM\Entity;

/**
 * Produto Entity
 *
 * @property int $id
 * @property string $codigoBarras
 * @property string $nome
 * @property string $principioAtivo
 * @property string $categoria
 * @property string $lote
 * @property \Cake\I18n\FrozenDate $validade
 * @property int $quantidade
 */
class Produto extends Entity
{

    /**
     * Fields that can be mass assigned using newEntity() or patchEntity().
     *
     * Note that when '*' is set to true, this allows all unspecified fields to
     * be mass assigned. For security purposes, it is advised to set '*' to false
     * (or remove it), and explicitly make individual fields accessible as needed.
     *
     * @var array
     */
    protected $_accessible = [
        'codigoBarras' => true,
        'nome' => true,
        'principioAtivo' => true,
        'categoria' => true,
        'lote' => true,
        'validade' => true,
        'quantidade' => true
    ];
}
