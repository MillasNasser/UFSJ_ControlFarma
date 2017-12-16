<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * Produtos Model
 *
 * @method \App\Model\Entity\Produto get($primaryKey, $options = [])
 * @method \App\Model\Entity\Produto newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\Produto[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\Produto|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\Produto patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\Produto[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\Produto findOrCreate($search, callable $callback = null, $options = [])
 */
class ProdutosTable extends Table
{

    /**
     * Initialize method
     *
     * @param array $config The configuration for the Table.
     * @return void
     */
    public function initialize(array $config)
    {
        parent::initialize($config);

        $this->setTable('produtos');
        $this->setDisplayField('id');
        $this->setPrimaryKey('id');
    }

    /**
     * Default validation rules.
     *
     * @param \Cake\Validation\Validator $validator Validator instance.
     * @return \Cake\Validation\Validator
     */
    public function validationDefault(Validator $validator)
    {
        $validator
            ->integer('id')
            ->allowEmpty('id', 'create');

        $validator
            ->scalar('codigoBarras')
            ->maxLength('codigoBarras', 13)
            ->requirePresence('codigoBarras', 'create')
            ->notEmpty('codigoBarras')
            ->add('codigoBarras', 'unique', ['rule' => 'validateUnique', 'provider' => 'table']);

        $validator
            ->scalar('nome')
            ->maxLength('nome', 250)
            ->requirePresence('nome', 'create')
            ->notEmpty('nome');

        $validator
            ->scalar('principioAtivo')
            ->maxLength('principioAtivo', 800)
            ->requirePresence('principioAtivo', 'create')
            ->notEmpty('principioAtivo');

        $validator
            ->scalar('categoria')
            ->maxLength('categoria', 100)
            ->requirePresence('categoria', 'create')
            ->notEmpty('categoria');

        $validator
            ->scalar('lote')
            ->maxLength('lote', 8)
            ->requirePresence('lote', 'create')
            ->notEmpty('lote')
            ->add('lote', 'unique', ['rule' => 'validateUnique', 'provider' => 'table']);

        $validator
            ->date('validade')
            ->requirePresence('validade', 'create')
            ->notEmpty('validade');

        $validator
            ->integer('quantidade')
            ->requirePresence('quantidade', 'create')
            ->notEmpty('quantidade');

        return $validator;
    }

    /**
     * Returns a rules checker object that will be used for validating
     * application integrity.
     *
     * @param \Cake\ORM\RulesChecker $rules The rules object to be modified.
     * @return \Cake\ORM\RulesChecker
     */
    public function buildRules(RulesChecker $rules)
    {
        $rules->add($rules->isUnique(['codigoBarras']));
        $rules->add($rules->isUnique(['lote']));

        return $rules;
    }
}
