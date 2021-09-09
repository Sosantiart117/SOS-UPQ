import pygame
import sys
import random

# Vectores de direcciones
up = (0,-1)
down = (0,1)
left = (-1,0)
right = (1,0)

# Tamaño de la pantalla
screen_width = 800
screen_height = 800
# Tamaño de la cuadricula
gridsize = 20
grid_width = screen_width/gridsize
grid_height = screen_height/gridsize



class Snake():
    def __init__(self): # Constructor del objeto snake
        self.init_size = 3 # Tamaño inicial
        self.length = self.init_size # Que el tamaño inicial sea el tamaño actual
        self.positions = [((screen_width/2), (screen_height/2))] # Iniciamos la posicion inicial en el centro
        self.direction = random.choice([up, down, left, right]) # Escogemos una direccion aleatoria
        self.color = (73, 92, 31) # Le damos color inicial
        self.score = 0 # El contador inicia en 0

    def get_head(self): # Nos dice la primer posocion, la cabeza
        return self.positions[0]

    def turn(self, punto_vis): # Checa donde esta viendo
        # Si esta viendo al mismo lugar (que no pueda regresarse sobre si misma), no hace nada
        if self.length > 1 and (punto_vis[0]*-1, punto_vis[1]*-1) == self.direction: 
            return
        else:
            self.direction = punto_vis 

    def move(self): # Se encarga de desplazar el cuerpo
        head = self.get_head()
        x,y = self.direction
        new = (((head[0]+(x*gridsize))%screen_width), (head[1]+(y*gridsize))%screen_height)
        if len(self.positions) > 2 and new in self.positions[2:]:
            self.reset() # Si la nueva posicion esta dentro del cuerpo, reinicia.
        else:
            self.positions.insert(0,new) # Se agrega la nueva posicion a la "cabeza"
            if len(self.positions) > self.length: # Verificamos hasta el tamaño que somos
                self.positions.pop() # Quitamos el ultimo bloque que ya esta en el primer lugar

    def reset(self): # Regresa la serpiente a su estado inicial
        self.length = self.init_size 
        self.positions = [((screen_width/2), (screen_height/2))]
        self.direction = random.choice([up, down, left, right])
        self.score = 0

    def draw(self,surface): # Esta funciona dibuja los cuadrados de la serpiente
        for pos in self.positions:
            r = pygame.Rect((pos[0], pos[1]), (gridsize,gridsize))
            pygame.draw.rect(surface, self.color, r)
            pygame.draw.rect(surface, (93,216, 228), r, 1)

    def handle_keys(self): # Controles para cambiar la direccion en la que va la serpiente
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            elif event.type == pygame.KEYDOWN: # Mapeamos las flechitas a las direcciones
                if event.key == pygame.K_UP:
                    self.turn(up)
                elif event.key == pygame.K_DOWN:
                    self.turn(down)
                elif event.key == pygame.K_LEFT:
                    self.turn(left)
                elif event.key == pygame.K_RIGHT:
                    self.turn(right)

class Food():
    def __init__(self):
        self.position = (0,0)
        self.color = (223, 163, 49)
        self.random_pos()

    def random_pos(self):
        self.position = (random.randint(0, grid_width-1)*gridsize, random.randint(0, grid_height-1)*gridsize)

    def draw(self, surface): # Dibuja la comida
        r = pygame.Rect((self.position[0], self.position[1]), (gridsize, gridsize))
        pygame.draw.rect(surface, self.color, r)
        pygame.draw.rect(surface, (93, 216, 228), r, 1)

def drawGrid(surface): # Dibujamos el patron del fondo
    for y in range(0, int(grid_height)):
        for x in range(0, int(grid_width)):
            if (x+y)%2 == 0: 
                r = pygame.Rect((x*gridsize, y*gridsize), (gridsize,gridsize))
                pygame.draw.rect(surface,(93,216,228), r)
            else:
                rr = pygame.Rect((x*gridsize, y*gridsize), (gridsize,gridsize))
                pygame.draw.rect(surface, (84,194,205), rr)



def main(): # Aqui pasa todo...

    # Incio del juego, se declara todo lo que se necesita antes (setup)
    pygame.init() # Requerido para que funcione

    clock = pygame.time.Clock()
    screen = pygame.display.set_mode((screen_width, screen_height), 0, 32) # Crea la ventana para el juego

    surface = pygame.Surface(screen.get_size())
    surface = surface.convert()
    drawGrid(surface)

    snake = Snake()
    food = Food()

    myfont = pygame.font.SysFont("monospace",16)

    while True:
        clock.tick(10)
        snake.handle_keys()
        drawGrid(surface)
        snake.move()
        if snake.get_head() == food.position:
            snake.length += 1
            snake.score += 1
            food.random_pos()
        snake.draw(surface)
        food.draw(surface)
        screen.blit(surface, (0,0))
        text = myfont.render("Score {0}".format(snake.score), 1, (0,0,0))
        screen.blit(text, (5,10))
        pygame.display.update()

main() # # Empieza la diversion
# Quien es kokun
