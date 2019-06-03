package jp.techacademy.ami.okabe.jumpactiongame

import com.badlogic.gdx.graphics.Texture

class Enemy(texture: Texture, srcX: Int, srcY: Int, srcWith: Int, srcHeight: Int)
    : GameObject(texture, srcX, srcY, srcWith, srcHeight) {

    companion object {
        val ENEMY_WIDTH = 1.0f
        val ENEMY_HEIGHT = 1.0f

        val ENEMY_VELOCITY = 2.0f
    }

    init {
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT)
        velocity.x = ENEMY_VELOCITY
    }

    fun update(deltaTime: Float) {
        x += velocity.x * deltaTime

        if (x < ENEMY_WIDTH / 2) {
            velocity.x = -velocity.x
            x = ENEMY_WIDTH / 2
        }

        if (x > GameScreen.WORLD_WIDTH - ENEMY_WIDTH / 2) {
            velocity.x = -velocity.x
            x = GameScreen.WORLD_WIDTH - ENEMY_WIDTH / 2
        }
    }
}